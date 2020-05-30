package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.User
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.extensions.functionOf
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelBuilder

object UserListItemViewModelBuilder : ViewModelBuilder<User, Int, UserListItemViewModel> {

    override fun getId(item: User): Int = item.id

    override fun onCreateViewModel(parent: Context, item: User): UserListItemViewModel {
        return UserListItemViewModel(parent).also { onUpdateViewModel(it, item) }
    }

    override fun onUpdateViewModel(viewModel: UserListItemViewModel, newItem: User) {
        viewModel.user.set(newItem)
    }

}

class UserListItemViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext) {

    val user = value<User>()

    val text = functionOf(user) {
        "User #${it.id} ${it.firstName} ${it.lastName}"
    }

}