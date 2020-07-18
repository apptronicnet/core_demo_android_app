package net.apptronic.core.demoapp.core

import net.apptronic.core.component.extensions.BaseComponent
import net.apptronic.core.demoapp.core.ui.AppViewModel
import net.apptronic.core.demoapp.core.ui.appViewModel
import net.apptronic.core.mvvm.viewmodel.dispatcher.viewModelDispatcher

/**
 * This is core app component, created it root context (which is [AppContext] for this application).
 * It implement base behavior or whole app.
 */
class AppComponent : BaseComponent(AppContext) {

    /**
     * Just declare [viewModelDispatcher]. Store it as maybe it needed to access [AppViewModel] later
     * from app core.
     */
    private val appViewModelDispatcher = viewModelDispatcher {
        it.appViewModel()
    }

}