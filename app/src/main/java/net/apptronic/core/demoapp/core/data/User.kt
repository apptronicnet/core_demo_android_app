package net.apptronic.core.demoapp.core.data

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val height: Int
) : DataObject