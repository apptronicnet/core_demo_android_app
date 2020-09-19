package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.property
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.incorrectCredentialsDialogViewModel(login: String) =
    IncorrectCredentialsDialogViewModel(viewModelContext(), login)

/**
 * It can be possible to pass parameter directly to [ViewModel]. This also can be some listeners
 * and callbacks, as [ViewModel] tree is not dependent on view layer state there is no need
 * to handle some save/restore state events: until it not destroyed by developer it will not
 * be destroyed at all.
 */
class IncorrectCredentialsDialogViewModel(
    context: ViewModelContext, login: String
) : ViewModel(context) {

    val message =
        property("Cannot login to '$login': incorrect credentials.")

    fun onCloseClick() {
        closeSelf()
    }

}