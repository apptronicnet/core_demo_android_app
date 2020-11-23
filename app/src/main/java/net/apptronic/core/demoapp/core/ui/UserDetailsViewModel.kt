package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.context.Contextual
import net.apptronic.core.demoapp.core.data.User
import net.apptronic.core.entity.commons.value
import net.apptronic.core.entity.function.map
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.viewModelContext

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