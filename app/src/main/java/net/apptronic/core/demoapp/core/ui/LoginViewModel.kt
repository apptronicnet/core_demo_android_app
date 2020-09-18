package net.apptronic.core.demoapp.core.ui

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
import net.apptronic.core.demoapp.core.CorrectLoginDescriptor
import net.apptronic.core.demoapp.core.CorrectPasswordDescriptor
import net.apptronic.core.demoapp.core.data.Api
import net.apptronic.core.mvvm.common.textInput
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext
import net.apptronic.core.mvvm.viewmodel.navigation.stackNavigator

fun Contextual.loginViewModel() = LoginViewModel(viewModelContext())

class LoginViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = injectNavigationRouter()
    private val api = inject<Api>()

    private val correctDemoLogin = inject(CorrectLoginDescriptor)
    private val correctDemoPassword = inject(CorrectPasswordDescriptor)

    val loginMessage =
        property(
            "Correct credentials: login='$correctDemoLogin' password='$correctDemoPassword'.\n" +
                    "Try both incorrect and correct credentials."
        )

    val dialogNavigator = stackNavigator()

    val login = textInput("")
    val password = textInput("")
    val isLoginButtonEnabled = property(login.text().isNotEmpty() and password.text().isNotEmpty())
    val isInProgress = value(false)
    val requestHideSoftKeyboardEvent = genericEvent()

    fun onLoginClick() {
        requestHideSoftKeyboardEvent.sendEvent()
        contextCoroutineScope.launch {
            isInProgress.set(true)
            val isSuccess = api.login(login.getText(), password.getText())
            if (isSuccess) {
                router.sendCommandsAsync(OpenDataList())
            } else {
                dialogNavigator.add(
                    incorrectCredentialsDialogViewModel(correctDemoLogin, correctDemoPassword)
                )
            }
            isInProgress.set(false)
        }
    }

}