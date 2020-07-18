package net.apptronic.core.demoapp.android.binder

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.login.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindEnabledDisabled
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.android.viewmodel.bindings.bindTextInput
import net.apptronic.core.android.viewmodel.bindings.navigation.bindDialogNavigator
import net.apptronic.core.component.entity.entities.subscribe
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.android.binding.bindProgressDialog
import net.apptronic.core.demoapp.core.ui.LoginViewModel

class LoginViewBinder : ViewBinder<LoginViewModel>() {

    override var layoutResId: Int? = R.layout.login

    override fun onBindView(view: View, viewModel: LoginViewModel) {
        with(view) {
            bindText(loginMessage, viewModel.loginMessage)
            bindDialogNavigator(viewModel.dialogNavigator)
            bindTextInput(edtLogin, viewModel.login)
            bindTextInput(edtPassword, viewModel.password)
            bindClickListener(btnLogin, viewModel::onLoginClick)
            bindEnabledDisabled(btnLogin, viewModel.isLoginButtonEnabled)
            bindProgressDialog(context, viewModel.isInProgress)
            viewModel.requestHideSoftKeyboardEvent.subscribe {
                val imm = ContextCompat.getSystemService(context, InputMethodManager::class.java)
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

}