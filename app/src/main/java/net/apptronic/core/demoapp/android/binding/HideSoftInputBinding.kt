package net.apptronic.core.demoapp.android.binding

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import net.apptronic.core.android.viewmodel.Binding
import net.apptronic.core.android.viewmodel.BindingContainer
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.entity.Entity
import net.apptronic.core.viewmodel.IViewModel

fun BindingContainer.bindHideSoftInput(view: View, source: Entity<*>) {
    +HideSoftInputBinding(source, view)
}

private class HideSoftInputBinding(
    private val source: Entity<*>,
    private val view: View
) : Binding() {

    override fun onBind(viewModel: IViewModel, viewBinder: ViewBinder<*>) {
        source.subscribe {
            val imm = ContextCompat.getSystemService(view.context, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}