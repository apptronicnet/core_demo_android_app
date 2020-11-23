package net.apptronic.core.demoapp.core.ui

import net.apptronic.core.context.Contextual
import net.apptronic.core.entity.commons.value
import net.apptronic.core.viewmodel.ViewModel
import net.apptronic.core.viewmodel.ViewModelContext
import net.apptronic.core.viewmodel.viewModelContext

/**
 * Default builder for [AppViewModel] which can be called from any [Contextual] - other [ViewModel],
 * [Component] etc.
 */
fun Contextual.appViewModel() = AppViewModel(viewModelContext())

class AppViewModel(context: ViewModelContext) : ViewModel(context) {

    val text = value("Hello from apptronic.net!")

}
