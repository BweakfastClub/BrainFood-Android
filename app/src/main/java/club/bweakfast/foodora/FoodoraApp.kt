package club.bweakfast.foodora

import android.app.Application
import club.bweakfast.foodora.di.component.DaggerFoodoraComponent
import club.bweakfast.foodora.di.component.FoodoraComponent
import club.bweakfast.foodora.di.module.FoodoraModule
import com.crashlytics.android.Crashlytics
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestLoggingListener
import io.fabric.sdk.android.Fabric

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
            .builder()
            .foodoraModule(FoodoraModule(applicationContext))
            .build()

        Fresco.initialize(this, frescoConfig)
        Fabric.with(this, Crashlytics())
    }

    companion object {
        lateinit var daggerComponent: FoodoraComponent
    }
}