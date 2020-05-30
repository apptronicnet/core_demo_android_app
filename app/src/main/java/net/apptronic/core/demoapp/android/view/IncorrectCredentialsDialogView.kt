package net.apptronic.core.demoapp.android.view

import android.view.View
import kotlinx.android.synthetic.main.incorrect_credentials_dialog.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.IncorrectCredentialsDialogViewModel

class IncorrectCredentialsDialogView : AndroidView<IncorrectCredentialsDialogViewModel>() {

    override var layoutResId: Int? = R.layout.incorrect_credentials_dialog

    override fun onBindView(view: View, viewModel: IncorrectCredentialsDialogViewModel) {
        with(view) {
            bindText(dialogMessage, viewModel.message)
            bindClickListener(btnClose, viewModel::onCloseClick)
        }
    }

}