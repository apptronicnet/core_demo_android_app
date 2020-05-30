package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.component.context.Context
import net.apptronic.core.mvvm.viewmodel.EmptyViewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.navigation.singleItemViewModelBuilder

object HeaderListItem

val HeaderListItemViewModelBuilder = singleItemViewModelBuilder(HeaderListItem) {
    HeaderListItemViewModel(it)
}

class HeaderListItemViewModel(parent: Context) : ViewModel(parent, EmptyViewModelContext)