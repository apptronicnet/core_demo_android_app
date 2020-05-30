package net.apptronic.core.demoapp.android.view

import android.view.View
import kotlinx.android.synthetic.main.list_item_user.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.UserListItemViewModel

class UserListItemView : AndroidView<UserListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_user

    override fun onBindView(view: View, viewModel: UserListItemViewModel) {
        with(view) {
            bindText(txtUser, viewModel.text)
        }
    }

}