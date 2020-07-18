package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.Robot
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext
import net.apptronic.core.mvvm.viewmodel.extensions.functionOf
import net.apptronic.core.mvvm.viewmodel.navigation.DynamicListNavigator
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelBuilder

/**
 * To use [ViewModel] in large lists it needed to create implementation of [ViewModelBuilder] which generates
 * concrete [ViewModel] by [DynamicListNavigator] request from specified type.
 *
 * Method [ViewModelBuilder.getId] needed to define when item [Robot] is complete ly or it's same item with
 * updated data. If list item of type [Robot] inside [DynamicListNavigator] will be replaced by item with same id
 * [DynamicListNavigator] will not destroy old [RobotListItemViewModel] and not create new [RobotListItemViewModel]
 * but find existing [RobotListItemViewModel] which bound to [Robot] id and call
 * [ViewModelBuilder.onUpdateViewModel].
 */
object RobotListItemViewModelBuilder : ViewModelBuilder<Robot, Int, RobotListItemViewModel> {

    override fun getId(item: Robot): Int = item.id

    override fun onCreateViewModel(parent: Context, item: Robot): RobotListItemViewModel {
        return parent.robotListItemViewModel().also { onUpdateViewModel(it, item) }
    }

    override fun onUpdateViewModel(viewModel: RobotListItemViewModel, newItem: Robot) {
        viewModel.robot.set(newItem)
    }

}

fun Contextual.robotListItemViewModel() = RobotListItemViewModel(viewModelContext())

/**
 * [ViewModel] can be used not only for whole app screen or ot's part, but also as list element.
 */
class RobotListItemViewModel(context: ViewModelContext) : ViewModel(context) {

    /**
     * Value or type [Robot] represented by this [RobotListItemViewModel]
     */
    val robot = value<Robot>()

    /**
     * The displayable main text on list item
     */
    val text = functionOf(robot) {
        "Robot #${it.id} ${it.name} "
    }

    /**
     * The displayable secondary text on list item
     */
    val manufacturer = functionOf(robot) {
        it.manufacturer
    }


}