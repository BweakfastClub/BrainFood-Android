package club.bweakfast.foodora

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import club.bweakfast.foodora.setup.SetupInfoActivity
import club.bweakfast.foodora.setup.SetupViewModel
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {
    @Inject
    lateinit var setupViewModel: SetupViewModel

    private lateinit var disposable: Disposable

    @SuppressLint("RxSubscribeOnError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        FoodoraApp.daggerComponent.inject(this)

        disposable = Completable.timer(1500, TimeUnit.MILLISECONDS)
            .subscribe {
                loadNextPage()
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
