package net.apptronic.core.demoapp.core

import net.apptronic.core.component.di.DependencyDescriptor
import net.apptronic.core.component.di.declareModule
import net.apptronic.core.component.di.dependencyDescriptor

/**
 * This is [DependencyDescriptor]s. [DependencyDescriptor] is unique key for using in
 * Dependency Injection, and this key also specifies concrete type of injected object.
 */
val CorrectLoginDescriptor = dependencyDescriptor<String>()
val CorrectPasswordDescriptor = dependencyDescriptor<String>()
val DemoLoginDelayMilliseconds = dependencyDescriptor<Long>()

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