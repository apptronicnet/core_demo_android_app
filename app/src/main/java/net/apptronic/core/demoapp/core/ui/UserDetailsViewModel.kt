package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.entity.functions.map
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.User
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.userDetailsViewModel(user: User) = UserDetailsViewModel(viewModelContext(), user)

class UserDetailsViewModel(context: ViewModelContext, val user: User) : ViewModel(context) {

    val firstName = value(user.firstName)
    val lastName = value(user.lastName)
    val age = value(user.age).map {
        "$it y. o."
    }
    val height = value(user.height).map {
        "$it cm"
    }

}