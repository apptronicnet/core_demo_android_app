package net.apptronic.core.demoapp

import android.app.Application
import net.apptronic.core.android.plugins.installAndroidApplicationPlugin
import net.apptronic.core.demoapp.android.AppBinderFactory
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
        AppContext.installAndroidApplicationPlugin(this) {
            binderFactory(AppBinderFactory)
            bindActivity(MainActivity::class, AppViewModel::class) {
                it.onBackPressed()
            }
        }
        appComponent = AppComponent()
    }

}