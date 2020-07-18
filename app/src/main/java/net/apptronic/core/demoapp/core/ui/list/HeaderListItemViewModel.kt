package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.component.context.Contextual
import net.apptronic.core.component.context.viewModelContext
import net.apptronic.core.mvvm.viewmodel.ViewModel
import net.apptronic.core.mvvm.viewmodel.ViewModelContext
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelBuilder
import net.apptronic.core.mvvm.viewmodel.navigation.singleItemViewModelBuilder

/**
 * This is simple definition of list item which represents list header
 */
object HeaderListItem

/**
 * When list item should be single instance in list it possible to use simplified [ViewModelBuilder], which only
 * creates some [ViewModel] of specified type uses for both list object and it's id some constant object.
 */
val HeaderListItemViewModelBuilder = singleItemViewModelBuilder(HeaderListItem) {
    it.headerListItemViewModel()
}

fun Contextual.headerListItemViewModel() = HeaderListItemViewModel(viewModelContext())

/**
 * [ViewModel] can be used not only for whole app screen or ot's part, but also as list element.
 * This is simple [ViewModel] which represents static header in list with no specific state.
 */
class HeaderListItemViewModel(context: ViewModelContext) : ViewModel(context)