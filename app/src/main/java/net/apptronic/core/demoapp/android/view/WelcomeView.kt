package net.apptronic.core.demoapp.android.view

import android.view.View
import kotlinx.android.synthetic.main.welcome.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.WelcomeViewModel

class WelcomeView : AndroidView<WelcomeViewModel>() {

    override var layoutResId: Int? = R.layout.welcome

    override fun onBindView(view: View, viewModel: WelcomeViewModel) {
        with(view) {
            bindClickListener(btnGoToLogin, viewModel::onLoginClick)
            bindClickListener(btnCloseApp, viewModel::onCloseClick)
        }
    }

}