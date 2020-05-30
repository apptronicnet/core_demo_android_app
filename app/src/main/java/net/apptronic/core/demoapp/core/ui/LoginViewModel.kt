package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.coroutines.coroutineLaunchers
import net.apptronic.core.component.entity.functions.and
import net.apptronic.core.component.entity.functions.isNotEmpty
import net.apptronic.core.component.genericEvent
import net.apptronic.core.component.inject
import net.apptronic.core.component.property
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.Api
import net.apptronic.core.demoapp.core.demo.CorrectLoginDescriptor
import net.apptronic.core.demoapp.core.demo.CorrectPasswordDescriptor
import net.apptronic.core.mvvm.common.textInput
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel

class LoginViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext) {

    private val api = inject<Api>()
    private val router = inject<Router>()

    private val loginCoroutineLauncher = coroutineLaunchers().local

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
        loginCoroutineLauncher.launch {
            isInProgress.set(true)
            val isSuccess = api.login(login.getText(), password.getText())
            if (isSuccess) {
                router.openDataList()
            } else {
                dialogNavigator.add(
                    IncorrectCredentialsDialogViewModel(
                        context, correctDemoLogin, correctDemoPassword
                    )
                )
            }
            isInProgress.set(false)
        }
    }

}