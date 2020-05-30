package net.apptronic.core.demoapp

import android.app.Application
import net.apptronic.core.android.plugins.installAndroidApplicationPlugin
import net.apptronic.core.demoapp.android.AppViewFactory
import net.apptronic.core.demoapp.core.AppComponent
import net.apptronic.core.demoapp.core.AppContext
import net.apptronic.core.demoapp.core.ui.AppViewModel

class AndroidApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        /**
         * First install Android integration plugin
         */
        AppContext.installAndroidApplicationPlugin(this) {
            viewFactory(AppViewFactory)
            bindActivity(MainActivity::class, AppViewModel::class) {
                it.onBackPressed()
            }
        }
        /**
         * Then create root app component and store it to prevent garbage collection. It's done!
         */
        appComponent = AppComponent()
    }

}