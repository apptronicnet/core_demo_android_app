package net.apptronic.core.demoapp.core.ext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import net.apptronic.core.demoapp.core.data.Robot
import net.apptronic.core.demoapp.core.data.RobotColor
import net.apptronic.core.demoapp.core.data.User
import kotlin.random.Random

object RemoteServerSimulator {

    private val correctLogin = "user"
    private val correctPassword = "12345"

    suspend fun login(login: String, password: String): Boolean {
        delay(2000)
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

    suspend fun getUsers(): List<User> {
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

    suspend fun getRobots(): List<Robot> {
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