package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.component.entity.functions.map
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.Robot
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext

fun Contextual.robotDetailsViewModel(robot: Robot) =
    RobotDetailsViewModel(viewModelContext(), robot)

class RobotDetailsViewModel(context: ViewModelContext, val robot: Robot) : ViewModel(context) {

    val name = value(robot.name)
    val manufacturer = value(robot.manufacturer)
    val weight = value(robot.weight).map {
        "$it kg"
    }
    val colorName = value(robot.color.colorName)
    val colorInt = value(robot.color.hexColor)

}