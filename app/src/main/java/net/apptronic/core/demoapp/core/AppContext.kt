package net.apptronic.core.demoapp.core

import net.apptronic.core.context.Context
import net.apptronic.core.context.coreContext
import net.apptronic.core.demoapp.core.data.DataModule

/**
 * This context is single instance of root [Context], which is responsible for whole app.
 */
val AppContext = coreContext {
    dependencyDispatcher.addModule(DataModule)
}