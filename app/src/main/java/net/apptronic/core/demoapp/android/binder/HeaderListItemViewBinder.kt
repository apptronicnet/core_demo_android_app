package net.apptronic.core.demoapp.android.binder

import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.HeaderListItemViewModel

class HeaderListItemViewBinder : ViewBinder<HeaderListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_header

    override fun onBindView() {
        // do nothing
        // this view contains no logic, only display
    }

}