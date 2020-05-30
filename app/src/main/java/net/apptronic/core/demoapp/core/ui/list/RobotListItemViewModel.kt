package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.component.context.Context
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.Robot
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.extensions.functionOf
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelBuilder

object RobotListItemViewModelBuilder : ViewModelBuilder<Robot, Int, RobotListItemViewModel> {

    override fun getId(item: Robot): Int = item.id

    override fun onCreateViewModel(parent: Context, item: Robot): RobotListItemViewModel {
        return RobotListItemViewModel(parent).also { onUpdateViewModel(it, item) }
    }

    override fun onUpdateViewModel(viewModel: RobotListItemViewModel, newItem: Robot) {
        viewModel.robot.set(newItem)
    }

}

class RobotListItemViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext) {

    val robot = value<Robot>()

    val text = functionOf(robot) {
        "Robot #${it.id} ${it.name} "
    }

    val manufacturer = functionOf(robot) {
        it.manufacturer
    }


}