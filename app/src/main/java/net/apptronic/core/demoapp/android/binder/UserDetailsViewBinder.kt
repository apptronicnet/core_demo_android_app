package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.details_user.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.UserDetailsViewModel

class UserDetailsViewBinder : ViewBinder<UserDetailsViewModel>() {

    override var layoutResId: Int? = R.layout.details_user

    override fun onBindView() {
        with(view) {
            bindText(txtDetailsFirstName, viewModel.firstName)
            bindText(txtDetailsLastName, viewModel.lastName)
            bindText(txtDetailsAge, viewModel.age)
            bindText(txtDetailsHeight, viewModel.height)
        }
    }

}