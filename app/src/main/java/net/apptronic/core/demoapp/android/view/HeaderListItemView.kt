package net.apptronic.core.demoapp.android.view

import android.view.View
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.list.HeaderListItemViewModel

class HeaderListItemView : AndroidView<HeaderListItemViewModel>() {

    override var layoutResId: Int? = R.layout.list_item_header

    override fun onBindView(view: View, viewModel: HeaderListItemViewModel) {
        // do nothing
    }

}