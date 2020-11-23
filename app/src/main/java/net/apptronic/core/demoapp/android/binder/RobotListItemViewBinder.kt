package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.list_item_robot.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.RobotListItemViewModel

class RobotListItemViewBinder : ViewBinder<RobotListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_robot

    override fun onBindView() {
        with(view) {
            bindText(txtRobot, viewModel.text)
            bindText(txtManufacturer, viewModel.manufacturer)
            bindClickListener(view, viewModel::onClick)
        }
    }

}