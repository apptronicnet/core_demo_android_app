package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.commons.routing.injectNavigationRouter
import net.apptronic.core.context.Contextual
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.viewModelContext

fun Contextual.welcomeViewModel() = WelcomeViewModel(viewModelContext())

class WelcomeViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = injectNavigationRouter()

    fun onLoginClick() {
        router.sendCommandsAsync(OpenLogin())
    }

    fun onCloseClick() {
        router.sendCommandsAsync(CloseApp())
    }

}