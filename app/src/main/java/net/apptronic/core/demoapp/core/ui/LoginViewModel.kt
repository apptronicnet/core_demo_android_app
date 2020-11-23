package net.apptronic.core.demoapp.core.ui

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.apptronic.core.commons.routing.injectNavigationRouter
import net.apptronic.core.context.Contextual
import net.apptronic.core.context.coroutines.contextCoroutineScope
import net.apptronic.core.demoapp.core.data.Api
import net.apptronic.core.entity.commons.genericEvent
import net.apptronic.core.entity.commons.property
import net.apptronic.core.entity.commons.value
import net.apptronic.core.entity.function.and
import net.apptronic.core.entity.function.isNotEmpty
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.commons.textInput
import net.apptronic.core.viewmodel.navigation.stackNavigator
import net.apptronic.core.viewmodel.viewModelContext

fun Contextual.loginViewModel() = LoginViewModel(viewModelContext())

/**
 * In this [ViewModel] shown:
 * - how computed properties work
 * - how to manage background-running tasks and progress
 */
class LoginViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = injectNavigationRouter()
    private val api = inject<Api>()

    val dialogNavigator = stackNavigator()

    val login = textInput("")
    val password = textInput("")

    val isLoginButtonEnabled = property(login.isNotEmpty() and password.isNotEmpty())
    val isInProgress = value(false)
    val requestHideSoftKeyboardEvent = genericEvent()

    private var loginJob: Job? = null

    fun onProgressCancelClick() {
        loginJob?.cancel()
        loginJob = null
    }

    fun onLoginClick() {
        requestHideSoftKeyboardEvent.update()
        loginJob = contextCoroutineScope.launch {
            try {
                isInProgress.set(true)
                val isSuccess = api.login(login.get(), password.get())
                if (isSuccess) {
                    router.sendCommandsAsync(OpenDataList())
                } else {
                    dialogNavigator.add(
                        incorrectCredentialsDialogViewModel(login.get())
                    )
                }
            } finally {
                isInProgress.set(false)
                loginJob = null
            }
        }
    }

}