package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.property
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.incorrectCredentialsDialogViewModel(correctLogin: String, correctPassword: String) =
    IncorrectCredentialsDialogViewModel(viewModelContext(), correctLogin, correctPassword)

/**
 * It can be possible to pass parameter directly to [ViewModel]. This also can be some listeners
 * and callbacks, as [ViewModel] tree is not dependent on view layer state there is no need
 * to handle some save/restore state events: until it not destroyed by developer it will no
 * be destroyed at all.
 */
class IncorrectCredentialsDialogViewModel(
    context: ViewModelContext, correctLogin: String, correctPassword: String
) : ViewModel(context) {

    val message =
        property("Incorrect credentials. Please try login '$correctLogin' and password '$correctPassword'.")

    fun onCloseClick() {
        closeSelf()
    }

}