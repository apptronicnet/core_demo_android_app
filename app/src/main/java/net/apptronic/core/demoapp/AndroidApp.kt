package net.apptronic.core.demoapp

import android.app.Activity
import android.app.Application
import net.apptronic.core.android.plugins.installAndroidApplicationPlugin
import net.apptronic.core.android.viewmodel.AndroidViewFactory
import net.apptronic.core.demoapp.android.AppViewFactory
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
        /**
         * First install Android integration plugin to [AppContext]]
         */
        AppContext.installAndroidApplicationPlugin(this) {
            /**
             * Specify [AndroidViewFactory] instance te be used
             */
            viewFactory(AppViewFactory)
            /**
             * Specify main user interface [Activity] and [ViewModel] binding
             */
            bindActivity(MainActivity::class, AppViewModel::class) {
                /**
                 * Back button handler for [AppViewModel] to be invoked when [Activity.onBackPressed] invoked.
                 */
                it.onBackPressed()
            }
        }
        /**
         * Then create root app component and store it to prevent garbage collection. It's done!
         */
        appComponent = AppComponent()
    }

}