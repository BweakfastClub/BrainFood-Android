package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import club.bweakfast.foodora.setup.SetupInfoActivity
import club.bweakfast.foodora.setup.SetupViewModel
import club.bweakfast.foodora.user.User
import club.bweakfast.foodora.user.UserViewModel
import club.bweakfast.foodora.util.onError
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {
    @Inject
    lateinit var setupViewModel: SetupViewModel
    @Inject
    lateinit var userViewModel: UserViewModel

    private lateinit var disposable: Disposable

    @SuppressLint("RxSubscribeOnError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        FoodoraApp.daggerComponent.inject(this)

        val actions = mutableListOf(Completable.timer(1500, TimeUnit.MILLISECONDS).toSingleDefault(User("")))
        if (userViewModel.isLoggedIn) actions.add(userViewModel.getUserInfo())

        disposable = Single.zip(actions) { it[0] as User }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { _, err ->
                if (err != null) onError(err, this)
                else loadNextPage()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun loadNextPage() {
        val intent = if (!setupViewModel.isSetupComplete) {
            Intent(this, SetupInfoActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        } else {
            Intent(this, MainActivity::class.java)
        }

        with(intent) {
            startActivity(this)
            finish()
        }
    }
}
