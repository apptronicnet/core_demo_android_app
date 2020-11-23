package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.list_item_user.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.UserListItemViewModel

class UserListItemViewBinder : ViewBinder<UserListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_user

    override fun onBindView() {
        with(view) {
            bindText(txtUser, viewModel.text)
            bindClickListener(view, viewModel::onClick)
        }
    }

}