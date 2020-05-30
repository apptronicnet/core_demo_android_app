package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.base.collections.wrapLists
import net.apptronic.core.component.context.Context
import net.apptronic.core.component.coroutines.coroutineLaunchers
import net.apptronic.core.component.inject
import net.apptronic.core.component.value
import net.apptronic.core.demoapp.core.data.DataRepository
import net.apptronic.core.demoapp.core.ui.list.HeaderListItem
import net.apptronic.core.demoapp.core.ui.list.ViewModelFactory
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel

class DataListViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext) {

    private val dataRepository = inject<DataRepository>()

    private val items = value<List<Any>>(emptyList())

    val listNavigator = listDynamicNavigator(items, ViewModelFactory)

    val isInProgress = value(false)

    init {
        coroutineLaunchers().local.launch {
            isInProgress.set(true)
            val data = dataRepository.getData()
            val allObjects = wrapLists(listOf(HeaderListItem), data)
            items.set(allObjects)
            isInProgress.set(false)
        }
    }

}