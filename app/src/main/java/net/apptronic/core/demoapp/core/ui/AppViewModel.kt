package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.Component
import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext
import net.apptronic.core.mvvm.viewmodel.adapter.BasicTransition

/**
 * Default builder for [AppViewModel] which can be called from any [Contextual] - other [ViewModel],
 * [Component] etc.
 */
fun Contextual.appViewModel() = AppViewModel(viewModelContext())

class AppViewModel(context: ViewModelContext) : ViewModel(context) {

    init {
        context.dependencyDispatcher.addInstance<Router>(AppRouter(this))
    }

    val navigator = stackNavigator()

    init {
        navigator.add(welcomeViewModel())
    }

    fun openLogin() {
        navigator.add(loginViewModel(), BasicTransition.Forward)
    }

    fun openDataList() {
        navigator.add(dataListViewModel(), BasicTransition.Forward)
    }

    fun onBackPressed(): Boolean {
        return navigator.popBackStack(BasicTransition.Backward)
    }

}

private class AppRouter(private val target: AppViewModel) : Router {

    override fun closeApp() {
        target.closeSelf()
    }

    override fun openLogin() {
        target.openLogin()
    }

    override fun openDataList() {
        target.openDataList()
    }

}

