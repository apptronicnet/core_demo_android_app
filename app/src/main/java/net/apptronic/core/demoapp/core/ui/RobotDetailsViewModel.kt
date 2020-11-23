package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.context.Contextual
import net.apptronic.core.demoapp.core.data.Robot
import net.apptronic.core.entity.commons.value
import net.apptronic.core.entity.function.map
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.viewModelContext

fun Contextual.robotDetailsViewModel(robot: Robot) =
    RobotDetailsViewModel(viewModelContext(), robot)

class RobotDetailsViewModel(context: ViewModelContext, val robot: Robot) : ViewModel(context) {

    val name = value(robot.name)
    val manufacturer = value(robot.manufacturer)
    val weight = value(robot.weight).map {
        "$it kg"
    }.distinct()
    val colorName = value(robot.color.colorName)
    val colorInt = value(robot.color.hexColor)

}