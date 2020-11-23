package net.apptronic.core.demoapp.core.data

import net.apptronic.core.context.Context
import net.apptronic.core.context.component.Component

interface Api {

    suspend fun login(login: String, password: String): Boolean

    suspend fun getUsers(): List<User>

    suspend fun getRobots(): List<Robot>

}

class DemoApiComponent(context: Context) : Component(context), Api {

    override suspend fun login(login: String, password: String): Boolean {
        return RemoteServerSimulator.login(login, password)
    }

    override suspend fun getUsers(): List<User> {
        return RemoteServerSimulator.getUsers()
    }

    override suspend fun getRobots(): List<Robot> {
        return RemoteServerSimulator.getRobots()
    }

}