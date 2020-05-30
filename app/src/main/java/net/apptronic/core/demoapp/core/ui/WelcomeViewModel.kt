package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.inject
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel

private val WelcomeContext = EmptyViewModelContext

class WelcomeViewModel(parent: Context) : ViewModel(parent, WelcomeContext) {

    private val router = inject<Router>()

    fun onLoginClick() {
        router.openLogin()
    }

    fun onCloseClick() {
        router.closeApp()
    }

}