package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.inject
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.welcomeViewModel() = WelcomeViewModel(viewModelContext())

class WelcomeViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = inject<Router>()

    fun onLoginClick() {
        router.openLogin()
    }

    fun onCloseClick() {
        router.closeApp()
    }

}