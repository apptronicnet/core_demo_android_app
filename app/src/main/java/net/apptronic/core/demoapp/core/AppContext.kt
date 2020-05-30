package net.apptronic.core.demoapp.core

import net.apptronic.core.component.context.coreContext
import net.apptronic.core.demoapp.core.data.DataModule
import net.apptronic.core.demoapp.core.demo.DemoModule

/**
 * This context is single instance, which is responsible for whole app.
 */
val AppContext = coreContext {
    dependencyDispatcher.addModule(DataModule)
    dependencyDispatcher.addModule(DemoModule)
}