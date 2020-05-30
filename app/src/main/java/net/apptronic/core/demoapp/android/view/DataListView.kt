package net.apptronic.core.demoapp.android.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.data_list.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.bindVisibleGone
import net.apptronic.core.android.viewmodel.bindings.navigation.bindListNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.DataListViewModel

class DataListView : AndroidView<DataListViewModel>() {

    override var layoutResId: Int? = R.layout.data_list

    override fun onBindView(view: View, viewModel: DataListViewModel) {
        with(view) {
            bindVisibleGone(progressBar, viewModel.isInProgress)
            recyclerView.layoutManager = LinearLayoutManager(context)
            bindListNavigator(recyclerView, viewModel.listNavigator)
        }
    }

}