package net.apptronic.core.demoapp.android.binder

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.data_list.view.*
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindVisibleGone
import net.apptronic.core.android.viewmodel.bindings.navigation.bindNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.android.ui.SpacingDecoration
import net.apptronic.core.demoapp.core.ui.DataListViewModel

class DataListViewBinder : ViewBinder<DataListViewModel>() {

    override var layoutResId: Int? = R.layout.data_list

    override fun onBindView() {
        with(view) {
            bindVisibleGone(progressBar, viewModel.isInProgress)
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            recyclerView.addItemDecoration(SpacingDecoration(resources.getDimensionPixelSize(R.dimen.list_spacing)))
            bindNavigator(recyclerView, viewModel.listNavigator)
        }
    }

}