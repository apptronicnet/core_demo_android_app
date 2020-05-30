package net.apptronic.core.demoapp.core.data

import net.apptronic.core.component.di.declareModule

val DataModule = declareModule {
    single<Api> {
        DemoApi(context = definitionContext())
    }
    factory<DataRepository> {
        DataRepositoryComponent(context = providedContext())
    }
}