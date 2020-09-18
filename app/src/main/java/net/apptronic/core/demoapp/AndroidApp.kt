package net.apptronic.core.demoapp

import android.app.Application
import net.apptronic.core.android.plugins.installAndroidApplicationPlugin
import net.apptronic.core.demoapp.android.AppBinderFactory
import net.apptronic.core.demoapp.android.AppTransitionAdapter
import net.apptronic.core.demoapp.core.AppComponent
import net.apptronic.core.demoapp.core.AppContext
import net.apptronic.core.demoapp.core.ui.AppViewModel

/**
 * [Application] class required to hold instance of main application [AppComponent]
 */
class AndroidApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // install plugin that enables easy integration for Android platform
        AppContext.installAndroidApplicationPlugin(this) {
            // injects [ViewBinderFactory] automatically to all navigator bindings
            binderFactory(AppBinderFactory)
            // bind [Activity] class with it's [ViewModel]
            bindActivity(MainActivity::class, AppViewModel::class) {
                // action which will executed when system back button pressed
                it.onBackPressed()
            }
            // injects custom adapter for building transitions
            viewTransitionFactory(AppTransitionAdapter)
        }
        // create instance of app core component to make application work
        appComponent = AppComponent()
    }

}