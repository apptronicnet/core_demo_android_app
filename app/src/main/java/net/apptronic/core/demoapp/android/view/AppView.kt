package net.apptronic.core.demoapp.android.view

import android.view.View
import kotlinx.android.synthetic.main.app.view.*
import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.bindings.navigation.bindStackNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.AppViewModel

class AppView : AndroidView<AppViewModel>() {

    override var layoutResId: Int? = R.layout.app

    override fun onBindView(view: View, viewModel: AppViewModel) {
        with(view) {
            bindStackNavigator(appContainer, viewModel.navigator)
        }
    }

}