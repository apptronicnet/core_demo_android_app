package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.property
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel

class IncorrectCredentialsDialogViewModel(
    parent: Context, correctLogin: String, correctPassword: String
) : ViewModel(parent, EmptyViewModelContext) {

    val message =
        property("Incorrect credentials. Please try login '$correctLogin' and password '$correctPassword'.")

    fun onCloseClick() {
        closeSelf()
    }

}