package net.apptronic.core.demoapp.core.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import net.apptronic.core.component.context.Context
import net.apptronic.core.component.di.DependencyDescriptor
import net.apptronic.core.component.extensions.BaseComponent
import net.apptronic.core.component.inject
import net.apptronic.core.demoapp.core.CorrectLoginDescriptor
import net.apptronic.core.demoapp.core.CorrectPasswordDescriptor
import net.apptronic.core.demoapp.core.DemoLoginDelayMilliseconds
import kotlin.random.Random

interface Api {

    suspend fun login(login: String, password: String): Boolean

    suspend fun getUsers(): List<User>

    suspend fun getRobots(): List<Robot>

}

class DemoApiComponent(context: Context) : BaseComponent(context), Api {

    /**
     * Using [DependencyDescriptor] for specifying type of injected value allows to specify unique injection
     * definition with pre-defined type
     */
    private val correctLogin = inject(CorrectLoginDescriptor)
    private val correctPassword = inject(CorrectPasswordDescriptor)
    private val demoLoginDelay = inject(DemoLoginDelayMilliseconds)

    override suspend fun login(login: String, password: String): Boolean {
        delay(demoLoginDelay)
        return login == correctLogin && password == correctPassword
    }

    private val usersCount = 10000

    private val firstNames = listOf(
        "Alex", "Bob", "Mary", "Jonh", "Jack", "Jim", "Jerry", "Anne", "Kate", "Bill"
    )

    private val lastNames = listOf(
        "Smith", "Johnson", "Andersen", "Lopez", "Garcia",
        "Martinez", "Williams", "Miller", "Brown", "Hernandez"
    )

    override suspend fun getUsers(): List<User> {
        return coroutineScope {
            withContext(Dispatchers.IO) {
                (1..usersCount).map {
                    User(
                        id = it,
                        firstName = firstNames.random(),
                        lastName = lastNames.random(),
                        age = Random.nextInt(12, 80),
                        height = Random.nextInt(140, 190)
                    )
                }
            }
        }
    }

    private val robotsCount = 10000

    private val robotNamePrefixes = listOf(
        "Do", "Re", "Mi", "Fa", "Sol", "La", "Si"
    )
    private val robotNameSuffixes = listOf(
        "dge", "mia", "sa", "llen", "ster", "nte", "nka"
    )
    private val robotManufacturers = listOf(
        "Google", "Apple", "Boston Dynamics", "Toyota", "SpaceX", "Tesla", "Vasiliy Petrovich"
    )

    override suspend fun getRobots(): List<Robot> {
        return coroutineScope {
            withContext(Dispatchers.IO) {
                (1..robotsCount).map {
                    Robot(
                        id = it,
                        name = robotNamePrefixes.random() + robotNameSuffixes.random(),
                        manufacturer = robotManufacturers.random(),
                        weight = Random.nextInt(2, 200),
                        color = RobotColor.values().random()
                    )
                }
            }
        }
    }

}