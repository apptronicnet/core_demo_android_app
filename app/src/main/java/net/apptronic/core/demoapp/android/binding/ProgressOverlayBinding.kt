package net.apptronic.core.demoapp.android.binding

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import net.apptronic.core.android.viewmodel.Binding
import net.apptronic.core.android.viewmodel.BindingContainer
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.component.entity.Entity
import net.apptronic.core.component.entity.entities.distinctUntilChanged
import net.apptronic.core.component.entity.subscribe
import net.apptronic.core.demoapp.R
import net.apptronic.core.mvvm.viewmodel.ViewModel

fun BindingContainer.bindProgressDialog(context: Context, source: Entity<Boolean>) {
    +ProgressOverlayBinding(source, context)
}

private class ProgressOverlayBinding(
    private val source: Entity<Boolean>, private val context: Context
) : Binding() {

    private var dialog: Dialog? = null

    override fun onBind(viewModel: ViewModel, viewBinder: ViewBinder<*>) {
        source.distinctUntilChanged().subscribe {
            if (it) {
                dialog = Dialog(context).apply {
                    setContentView(R.layout.progress_dialog)
                    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    setCancelable(false)
                    show()
                }
            } else {
                dialog?.dismiss()
                dialog = null
            }
        }
    }

    override fun onUnbind(action: () -> Unit) {
        super.onUnbind(action)
        dialog?.dismiss()
        dialog = null
    }

}