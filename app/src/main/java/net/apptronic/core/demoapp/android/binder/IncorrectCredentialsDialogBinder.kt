package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.incorrect_credentials_dialog.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.IncorrectCredentialsDialogViewModel

class IncorrectCredentialsDialogBinder : ViewBinder<IncorrectCredentialsDialogViewModel>() {

    override var layoutResId: Int? = R.layout.incorrect_credentials_dialog

    override fun onBindView() {
        with(view) {
            bindText(dialogMessage, viewModel.message)
            bindClickListener(btnClose, viewModel::onCloseClick)
        }
    }

}