package net.apptronic.core.demoapp.core.data

data class Robot(
    val id: Int,
    val name: String,
    val manufacturer: String,
    val weight: Int,
    val color: RobotColor
) : DataObject