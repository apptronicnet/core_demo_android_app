package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.di.declareModule
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.adapter.BasicTransition
import net.apptronic.core.mvvm.viewmodel.defineViewModelContext

val AppViewModelContext = defineViewModelContext {
    dependencyDispatcher.addModule(AppUiModule)
}

private val AppUiModule = declareModule {
}

class AppViewModel(parent: Context) : ViewModel(parent, AppViewModelContext) {

    init {
        context.dependencyDispatcher.addInstance<Router>(AppRouter(this))
    }

    val navigator = stackNavigator()

    init {
        navigator.add(WelcomeViewModel(parent = context))
    }

    fun openLogin() {
        navigator.add(LoginViewModel(parent = context), BasicTransition.Forward)
    }

    fun openDataList() {
        navigator.add(DataListViewModel(parent = context), BasicTransition.Forward)
    }

    fun onBackPressed(): Boolean {
        return navigator.popBackStack(BasicTransition.Back)
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

