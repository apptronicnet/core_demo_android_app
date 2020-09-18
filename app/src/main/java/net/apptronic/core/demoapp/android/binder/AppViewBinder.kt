package net.apptronic.core.demoapp.android.binder

import android.view.View
import kotlinx.android.synthetic.main.app.view.*
import net.apptronic.core.android.anim.animations.ViewAnimation_Fade
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindVisibleGone
import net.apptronic.core.android.viewmodel.bindings.navigation.bindStackNavigator
import net.apptronic.core.component.entity.functions.map
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.AppViewModel

class AppViewBinder : ViewBinder<AppViewModel>() {

    override var layoutResId: Int? = R.layout.app

    override fun onBindView(view: View, viewModel: AppViewModel) {
        with(view) {
            bindStackNavigator(appContainer, viewModel.navigator)
            bindClickListener(fadeOverlay, viewModel::onTapOverlay)
            val isOverlayVisible = viewModel.overlayNavigator.map {
                it.visibleModel != null
            }
            bindVisibleGone(fadeOverlay, isOverlayVisible) {
                enter = ViewAnimation_Fade
                exit = ViewAnimation_Fade.reversed()
            }
            bindStackNavigator(overlayContainer, viewModel.overlayNavigator)
        }
    }

}