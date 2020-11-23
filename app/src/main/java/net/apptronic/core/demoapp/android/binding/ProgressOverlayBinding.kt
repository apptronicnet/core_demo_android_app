package net.apptronic.core.demoapp.android.binding

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import net.apptronic.core.android.viewmodel.Binding
import net.apptronic.core.android.viewmodel.BindingContainer
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.demoapp.R
import net.apptronic.core.entity.Entity
import net.apptronic.core.entity.commons.distinctUntilChanged
import net.apptronic.core.viewmodel.IViewModel

fun BindingContainer.bindProgressDialog(
    context: Context, source: Entity<Boolean>, onCancel: () -> Unit
) {
    +ProgressOverlayBinding(source, context, onCancel)
}

private class ProgressOverlayBinding(
    private val source: Entity<Boolean>,
    private val context: Context,
    private val onCancel: () -> Unit
) : Binding() {

    private var dialog: Dialog? = null

    override fun onBind(viewModel: IViewModel, viewBinder: ViewBinder<*>) {
        source.distinctUntilChanged().subscribe {
            if (it) {
                dialog = Dialog(context).apply {
                    setContentView(R.layout.progress_dialog)
                    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    setOnCancelListener {
                        onCancel()
                        dialog = null
                    }
                    show()
                }
            } else {
                dialog?.dismiss()
                dialog = null
            }
        }
        onUnbind {
            dialog?.dismiss()
            dialog = null
        }
    }

}