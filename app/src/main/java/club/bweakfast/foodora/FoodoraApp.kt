package club.bweakfast.foodora

import android.app.Application
import club.bweakfast.foodora.di.component.DaggerFoodoraComponent
import club.bweakfast.foodora.di.component.FoodoraComponent
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestLoggingListener

/**
 * Created by silve on 3/2/2018.
 */

class FoodoraApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val requestListeners = setOf(RequestLoggingListener())
        val frescoConfig = ImagePipelineConfig.newBuilder(this)
            .setDownsampleEnabled(true)
            .setRequestListeners(requestListeners)
            .build()
        daggerComponent = DaggerFoodoraComponent
            .create()

        Fresco.initialize(this, frescoConfig)
    }

    companion object {
        lateinit var daggerComponent: FoodoraComponent
    }
}