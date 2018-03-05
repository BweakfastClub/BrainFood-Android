package club.bweakfast.foodora.di.component

import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.di.module.FoodoraModule
import dagger.Component

/**
 * Created by silve on 3/2/2018.
 */

@Component(modules = [FoodoraModule::class])
interface FoodoraComponent {
    fun inject(activity: AuthenticationActivity)
}