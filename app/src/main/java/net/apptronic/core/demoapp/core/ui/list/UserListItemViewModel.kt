package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.commons.routing.injectNavigationRouter
import net.apptronic.core.context.Context
import net.apptronic.core.context.Contextual
import net.apptronic.core.demoapp.core.data.User
import net.apptronic.core.demoapp.core.ui.OpenUserDetails
import net.apptronic.core.entity.commons.value
import net.apptronic.core.entity.function.functionOf
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.navigation.ViewModelBuilder
import net.apptronic.core.viewmodel.viewModelContext

/**
 * To use [ViewModel] in large lists it needed to create implementation of [ViewModelBuilder] which generates
 * concrete [ViewModel] by [DynamicListNavigator] request from specified type.
 *
 * Method [ViewModelBuilder.getId] needed to define when item [User] is complete ly or it's same item with
 * updated data. If list item of type [User] inside [DynamicListNavigator] will be replaced by item with same id
 * [DynamicListNavigator] will not destroy old [UserListItemViewModel] and not create new [UserListItemViewModel]
 * but find existing [UserListItemViewModel] which bound to [User] id and call
 * [ViewModelBuilder.onUpdateViewModel].
 */
object UserListItemViewModelBuilder : ViewModelBuilder<User, Int, UserListItemViewModel> {

    override fun getId(item: User): Int = item.id

    override fun onCreateViewModel(parent: Context, item: User): UserListItemViewModel {
        return parent.userListItemViewModel().also { onUpdateViewModel(it, item) }
    }

    override fun onUpdateViewModel(viewModel: UserListItemViewModel, newItem: User) {
        viewModel.user.set(newItem)
    }

}

fun Contextual.userListItemViewModel() = UserListItemViewModel(viewModelContext())

/**
 * [ViewModel] can be used not only for whole app screen or ot's part, but also as list element.
 */
class UserListItemViewModel(context: ViewModelContext) : ViewModel(context) {

    private val router = injectNavigationRouter()

    /**
     * Value or type [User] represented by this [UserListItemViewModel]
     */
    val user = value<User>()

    /**
     * The displayable text on list item
     */
    val text = functionOf(user) {
        "User #${it.id} ${it.firstName} ${it.lastName}"
    }

    fun onClick() {
        router.sendCommandsAsync(OpenUserDetails(user.get()))
    }

}