package net.apptronic.core.demoapp.core

import net.apptronic.core.component.di.Descriptor
import net.apptronic.core.component.di.createDescriptor
import net.apptronic.core.component.di.declareModule

/**
 * This is dependency [Descriptor]s. [Descriptor] is unique key for using in Dependency
 * Injection, and this key also specifies concrete type of injected object.
 */
val CorrectLoginDescriptor = createDescriptor<String>()
val CorrectPasswordDescriptor = createDescriptor<String>()
val DemoLoginDelayMilliseconds = createDescriptor<Long>()

val DemoModule = declareModule {
    single(CorrectLoginDescriptor) {
        "user"
    }
    single(CorrectPasswordDescriptor) {
        "pass"
    }
    single(DemoLoginDelayMilliseconds) {
        1500L
    }
}