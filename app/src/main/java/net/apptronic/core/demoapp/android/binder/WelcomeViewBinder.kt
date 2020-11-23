package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.welcome.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.WelcomeViewModel

class WelcomeViewBinder : ViewBinder<WelcomeViewModel>() {

    override var layoutResId: Int? = R.layout.welcome

    override fun onBindView() {
        with(view) {
            bindClickListener(btnGoToLogin, viewModel::onLoginClick)
            bindClickListener(btnCloseApp, viewModel::onCloseClick)
        }
    }

}