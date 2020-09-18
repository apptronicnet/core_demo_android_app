package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.commons.navigation.injectNavigationRouter
import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.welcomeViewModel() = WelcomeViewModel(viewModelContext())

class WelcomeViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = injectNavigationRouter()

    fun onLoginClick() {
        router.sendCommands(OpenLogin())
    }

    fun onCloseClick() {
        router.sendCommands(CloseApp())
    }

}