package net.apptronic.core.demoapp.core.data

import net.apptronic.core.context.di.declareModule

val DataModule = declareModule {
    single<Api> {
        DemoApiComponent(context = definitionContext())
    }
    factory<DataRepository> {
        DataRepositoryComponent(context = providedContext())
    }
}