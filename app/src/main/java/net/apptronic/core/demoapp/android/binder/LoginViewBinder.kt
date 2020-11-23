package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.login.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindEnabledDisabled
import net.apptronic.core.android.viewmodel.bindings.bindTextInput
import net.apptronic.core.android.viewmodel.bindings.navigation.DialogMode
import net.apptronic.core.android.viewmodel.bindings.navigation.bindNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.android.binding.bindHideSoftInput
import net.apptronic.core.demoapp.android.binding.bindProgressDialog
import net.apptronic.core.demoapp.core.ui.LoginViewModel

class LoginViewBinder : ViewBinder<LoginViewModel>() {

    override var layoutResId: Int? = R.layout.login

    override fun onBindView() {
        with(view) {
            bindNavigator(viewModel.dialogNavigator, DialogMode())
            bindTextInput(edtLogin, viewModel.login)
            bindTextInput(edtPassword, viewModel.password)
            bindClickListener(btnLogin, viewModel::onLoginClick)
            bindEnabledDisabled(btnLogin, viewModel.isLoginButtonEnabled)
            bindProgressDialog(context, viewModel.isInProgress, viewModel::onProgressCancelClick)
            bindHideSoftInput(view, viewModel.requestHideSoftKeyboardEvent)
        }
    }

}