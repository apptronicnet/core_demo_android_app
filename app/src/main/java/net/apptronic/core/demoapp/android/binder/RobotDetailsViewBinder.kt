package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.details_robot.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindText
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.RobotDetailsViewModel

class RobotDetailsViewBinder : ViewBinder<RobotDetailsViewModel>() {

    override var layoutResId: Int? = R.layout.details_robot

    override fun onBindView() {
        with(view) {
            bindText(txtDetailsName, viewModel.name)
            bindText(txtDetailsManufacturer, viewModel.manufacturer)
            bindText(txtDetailsWeight, viewModel.weight)
            bindText(txtDetailsColor, viewModel.colorName)
            viewModel.colorInt.subscribe {
                txtDetailsColor.setTextColor(it)
            }
        }
    }

}