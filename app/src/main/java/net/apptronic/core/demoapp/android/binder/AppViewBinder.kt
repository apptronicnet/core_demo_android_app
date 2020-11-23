package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.app.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.AppViewModel

class AppViewBinder : ViewBinder<AppViewModel>() {

    override var layoutResId: Int? = R.layout.app

    override fun onBindView() {
        with(view) {
            bindText(text, viewModel.text)
        }
    }

}