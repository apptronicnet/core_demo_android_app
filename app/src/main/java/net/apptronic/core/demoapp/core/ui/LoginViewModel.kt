package net.apptronic.core.demoapp.core.ui

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.apptronic.core.commons.navigation.injectNavigationRouter
import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.coroutines.contextCoroutineScope
import net.apptronic.core.component.entity.functions.and
import net.apptronic.core.component.entity.functions.isNotEmpty
import net.apptronic.core.component.genericEvent
import net.apptronic.core.component.inject
import net.apptronic.core.component.property
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.Api
import net.apptronic.core.mvvm.common.textInput
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext
import net.apptronic.core.mvvm.viewmodel.navigation.stackNavigator

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

    val isLoginButtonEnabled = property(login.text().isNotEmpty() and password.text().isNotEmpty())
    val isInProgress = value(false)
    val requestHideSoftKeyboardEvent = genericEvent()

    private var loginJob: Job? = null

    fun onProgressCancelClick() {
        loginJob?.cancel()
        loginJob = null
    }

    fun onLoginClick() {
        requestHideSoftKeyboardEvent.sendEvent()
        loginJob = contextCoroutineScope.launch {
            try {
                isInProgress.set(true)
                val isSuccess = api.login(login.getText(), password.getText())
                if (isSuccess) {
                    router.sendCommandsAsync(OpenDataList())
                } else {
                    dialogNavigator.add(
                        incorrectCredentialsDialogViewModel(login.getText())
                    )
                }
            } finally {
                isInProgress.set(false)
                loginJob = null
            }
        }
    }

}