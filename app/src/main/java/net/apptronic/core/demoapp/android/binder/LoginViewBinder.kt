package net.apptronic.core.demoapp.android.binder

import android.view.View
import kotlinx.android.synthetic.main.login.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindEnabledDisabled
import net.apptronic.core.android.viewmodel.bindings.bindTextInput
import net.apptronic.core.android.viewmodel.bindings.navigation.bindDialogNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.android.binding.bindHideSoftInput
import net.apptronic.core.demoapp.android.binding.bindProgressDialog
import net.apptronic.core.demoapp.core.ui.LoginViewModel

class LoginViewBinder : ViewBinder<LoginViewModel>() {

    override var layoutResId: Int? = R.layout.login

    override fun onBindView(view: View, viewModel: LoginViewModel) {
        with(view) {
            bindDialogNavigator(viewModel.dialogNavigator)
            bindTextInput(edtLogin, viewModel.login)
            bindTextInput(edtPassword, viewModel.password)
            bindClickListener(btnLogin, viewModel::onLoginClick)
            bindEnabledDisabled(btnLogin, viewModel.isLoginButtonEnabled)
            bindProgressDialog(context, viewModel.isInProgress, viewModel::onProgressCancelClick)
            bindHideSoftInput(view, viewModel.requestHideSoftKeyboardEvent)
        }
    }

}