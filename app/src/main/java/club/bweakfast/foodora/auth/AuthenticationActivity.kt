package club.bweakfast.foodora.auth

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.setup.SetupInfoActivity
import club.bweakfast.foodora.user.UserViewModel
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.parseError
import club.bweakfast.foodora.util.showDarkStatusIcons
import club.bweakfast.foodora.util.showFragment
import club.bweakfast.foodora.util.showProgress
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login_register.*
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Rushil on 8/19/2017.
 */

class AuthenticationActivity : AppCompatActivity() {
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private var loading: Boolean = false
        set(value) {
            showProgress(value, progressView, container)
            field = value
        }

    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        val daggerComponent = FoodoraApp.daggerComponent
        daggerComponent.inject(this)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
        showDarkStatusIcons(window.decorView, true)

        if (userViewModel.isLoggedIn) {
            onLoginSuccess()
        } else {
            loadLoginPage()
        }
    }

    private fun login(email: String, password: String) {
        loading = true
        subscriptions.add(
            userViewModel.login(email, password)
                .andThen(userViewModel.getUserInfo())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { _, err ->
                    if (err != null) {
                        handleError(err)
                    } else {
                        onLoginSuccess()
                    }
                    loading = false
                }
        )
    }

    private fun onLoginSuccess() {
        Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
            finish()
        }
    }

    private fun onRegisterSuccess() {
        Intent(this, SetupInfoActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(this)
            finish()
        }
    }

    private fun register(name: String, email: String, password: String) {
        loading = true
        subscriptions.add(
            userViewModel.register(name, email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Toast.makeText(applicationContext, getString(R.string.success_register), Toast.LENGTH_SHORT).show()
                    onRegisterSuccess()
                    loading = false
                }, {
                    handleError(it)
                    loading = false
                })
        )
    }

    private fun loadLoginPage() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            val fragment = LoginFragment.newInstance()
            subscriptions.addAll(
                fragment.login
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(Schedulers.trampoline())
                    .subscribe(
                        { (email, password) -> login(email, password) },
                        ::handleError
                    ),
                fragment.loadRegisterPage
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(Schedulers.trampoline())
                    .subscribe({ loadRegisterPage() }, ::handleError)
            )
            showFragment(fragment, setAnimations = this::showFragmentAnimations)
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun loadRegisterPage() {
        val fragment = RegisterFragment.newInstance()
        subscriptions.addAll(
            fragment.register
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.trampoline())
                .subscribe(
                    { (name, email, password) -> register(name, email, password) },
                    { onError(it, this) }
                ),
            fragment.loadLoginPage
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.trampoline())
                .subscribe({ loadLoginPage() }, ::handleError)
        )
        showFragment(fragment, "Register", setAnimations = this::showFragmentAnimations)
    }

    private fun showFragmentAnimations(transaction: FragmentTransaction) {
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
    }

    private fun handleError(error: Throwable) {
        onError(error, this) { _, _ ->
            var message: String = getString(R.string.error_occurred)

            if (error is HttpException) {
                val errorMessage = parseError(error.response().errorBody())
                if (errorMessage == null) {
                    when (error.code()) {
                        401 -> message = getString(R.string.error_login_invalid)
                    }
                } else {
                    message = errorMessage
                }
            }

            message
        }
    }
}