package club.bweakfast.foodora.auth

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import club.bweakfast.foodora.ErrorDisplay
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.showFragment
import club.bweakfast.foodora.showProgress
import club.bweakfast.foodora.user.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login_register.*
import javax.inject.Inject

/**
 * Created by Rushil on 8/19/2017.
 */

class AuthenticationActivity : AppCompatActivity() {
    private val TAG: String = "AuthenticationActivity"
    private val subscriptions: CompositeDisposable = CompositeDisposable()

    private var loading: Boolean = false
        set(value) {
//            subscriptions.add(
            showProgress(value, progressView, container)
            /*.subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.newThread())
            .subscribe({*/ /* }, {})*/
            field = value
//            )
        }

    private lateinit var authService: AuthenticationService

    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        val daggerComponent = FoodoraApp.daggerComponent
        daggerComponent.inject(this)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                loadLoginBackground()
            }
        }

//        if (authService.isLoggedIn) {
//            onLoginSuccess()
//        } else {
        loadLoginPage()
//        }
    }

    private fun login(email: String, password: String) {
        loading = true
        subscriptions.add(
            userViewModel.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    loading = false
                    onLoginSuccess()
                }, this::onNetworkError)
        )
    }

    private fun onLoginSuccess() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun register(email: String, password: String) {
        loading = true
        subscriptions.add(
            userViewModel.register(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.success_register),
                        Toast.LENGTH_SHORT
                    ).show()
                    loadLoginPage()
                    loading = false
                }, this::onNetworkError)
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
                        { onNetworkError(it) }
                    ),
                fragment.loadRegisterPage
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(Schedulers.trampoline())
                    .subscribe({ loadRegisterPage() }, { onNetworkError(it) })
            )
            showFragment(fragment, setAnimations = this::showFragmentAnimations)
        } else {
            supportFragmentManager.popBackStack()
        }

        loadLoginBackground()
    }

    private fun loadRegisterPage() {
        val fragment = RegisterFragment.newInstance()
        subscriptions.addAll(
            fragment.register
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.trampoline())
                .subscribe(
                    { (email, password) -> register(email, password) },
                    { onNetworkError(it) }
                ),
            fragment.loadLoginPage
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.trampoline())
                .subscribe({ loadLoginPage() }, { onNetworkError(it) })
        )
        showFragment(fragment, true, "Register", setAnimations = this::showFragmentAnimations)
        loadRegisterBackground()
    }

    private fun loadLoginBackground() {
        val backgroundURI = "res:/${R.drawable.bg_login}"
        background.setImageURI(Uri.parse(backgroundURI))
    }

    private fun loadRegisterBackground() {
        val backgroundURI = "res:/${R.drawable.bg_register}"
        background.setImageURI(Uri.parse(backgroundURI))
    }

    private fun showFragmentAnimations(transaction: FragmentTransaction) {
//        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
    }

    private fun onNetworkError(error: Throwable) {
        Log.e(TAG, "Network error", error)
        loading = false
        Toast.makeText(applicationContext, getString(R.string.error_occurred), Toast.LENGTH_SHORT)
            .show()
    }

    private fun handleError(error: String?) {
        when {
            error == null -> Toast.makeText(
                applicationContext,
                getString(R.string.error_occurred),
                Toast.LENGTH_SHORT
            ).show()
            error.contains("is Null") -> {
                val fragment =
                    supportFragmentManager.findFragmentById(R.id.container) as ErrorDisplay
                fragment.showError(error)
            }
            else -> Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
        }
    }
}