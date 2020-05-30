package net.apptronic.core.demoapp.android.view

import android.view.View
import kotlinx.android.synthetic.main.list_item_robot.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.RobotListItemViewModel

class RobotListItemView : AndroidView<RobotListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_robot

    override fun onBindView(view: View, viewModel: RobotListItemViewModel) {
        with(view) {
            bindText(txtRobot, viewModel.text)
            bindText(txtManufacturer, viewModel.manufacturer)
        }
    }

}