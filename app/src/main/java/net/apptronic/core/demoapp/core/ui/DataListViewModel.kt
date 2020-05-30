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
import net.apptronic.core.mvvm.viewmodel.navigation.DynamicListNavigator
import net.apptronic.core.mvvm.viewmodel.navigation.ListNavigator

class DataListViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext) {

    private val dataRepository = inject<DataRepository>()

    private val items = value<List<Any>>(emptyList())

    /**
     * This is type of [ListNavigator] which not uses list of concrete [ViewModel] but list of some objects,
     * for which it will generate [ViewModel]s on fly. This is useful for large lists where generation of all
     * [ViewModel]s are too CPU-consuming.
     *
     * Also it can be useful when content of list are volatile and logic of adding/removing/positioning items
     * in list much easier when working with some keys/ids than with concrete [ViewModel]s which needed to be
     * manually moved inside list.
     *
     * [ViewModelFactory] is required in case of [DynamicListNavigator] as it is object which generates and updates
     * [ViewModel]s for it.
     */
    val listNavigator = listDynamicNavigator(items, ViewModelFactory)

    val isInProgress = value(false)

    init {
        coroutineLaunchers().local.launch {
            isInProgress.set(true)
            val data = dataRepository.getData()

            /**
             * [wrapLists] is lazy list combinator, which not copies all objects into new [List] but proxies requests
             * for each [List] item by it's index and dynamically selects from concrete inner [List] based in inners
             * lists lengths and order. This allows to skip "copying items to new list and create list, which are
             * combining all items of source lists, very fast.
             *
             * At this place it needed to add single item at list start, which may require many time on large lists.
             * Instead of that the single-item list is created and then 2 lists wrapped into one without copying.
             */
            val allObjects = wrapLists(listOf(HeaderListItem), data)
            items.set(allObjects)
            isInProgress.set(false)
        }
    }

}