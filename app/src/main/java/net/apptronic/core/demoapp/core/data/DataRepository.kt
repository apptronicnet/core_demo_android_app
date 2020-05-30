package net.apptronic.core.demoapp.core.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import net.apptronic.core.component.context.Context
import net.apptronic.core.component.extensions.BaseComponent
import net.apptronic.core.component.inject
import kotlin.math.min

interface DataRepository {

    suspend fun getData(): List<DataObject>

}

class DataRepositoryComponent(context: Context) : BaseComponent(context), DataRepository {

    private val api = inject<Api>()

    override suspend fun getData(): List<DataObject> {
        delay(1000)
        return coroutineScope {
            withContext(Dispatchers.Default) {
                val users = api.getUsers()
                val robots = api.getRobots()
                mutableListOf<DataObject>().apply {
                    val edge = min(users.size, robots.size)
                    (0 until edge).forEach {
                        add(users[it])
                        add(robots[it])
                    }
                    (edge until users.size).forEach {
                        add(users[it])
                    }
                    (edge until users.size).forEach {
                        add(users[it])
                    }
                }
            }
        }
    }

}