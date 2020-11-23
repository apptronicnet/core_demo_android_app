package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.commons.routing.DefaultNavigationHandler
import net.apptronic.core.commons.routing.hostNavigationRouter
import net.apptronic.core.commons.routing.registerNavigationHandler
import net.apptronic.core.context.Contextual
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.navigation.BasicTransition
import net.apptronic.core.viewmodel.navigation.stackNavigator
import net.apptronic.core.viewmodel.viewModelContext

/**
 * Default builder for [AppViewModel] which can be called from any [Contextual] - other [ViewModel],
 * [Component] etc.
 */
fun Contextual.appViewModel() = AppViewModel(viewModelContext())

class AppViewModel(context: ViewModelContext) : ViewModel(context), DefaultNavigationHandler {

    init {
        hostNavigationRouter()
    }

    val navigator = stackNavigator()
    val overlayNavigator = stackNavigator()

    init {
        navigator.add(welcomeViewModel())
        registerNavigationHandler(this)
    }

    override fun onNavigationCommand(command: Any): Boolean {
        return when (command) {
            is OpenLogin -> {
                navigator.add(loginViewModel(), BasicTransition.Forward)
                true
            }
            is OpenDataList -> {
                navigator.add(dataListViewModel(), BasicTransition.Forward)
                true
            }
            is CloseApp -> {
                closeSelf()
                true
            }
            is OpenUserDetails -> {
                overlayNavigator.add(
                    userDetailsViewModel(command.data),
                    Transitions.ShowHideBottomSheet
                )
                true
            }
            is OpenRobotDetails -> {
                overlayNavigator.add(
                    robotDetailsViewModel(command.data),
                    Transitions.ShowHideBottomSheet
                )
                true
            }
            else -> false
        }
    }

    fun onTapOverlay() {
        overlayNavigator.removeLast(Transitions.ShowHideBottomSheet)
    }

    fun onBackPressed(): Boolean {
        if (overlayNavigator.removeLast(Transitions.ShowHideBottomSheet)) {
            return true
        }
        return navigator.popBackStack(BasicTransition.Backward)
    }

}
