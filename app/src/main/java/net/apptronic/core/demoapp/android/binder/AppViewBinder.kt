package net.apptronic.core.demoapp.android.binder

import kotlinx.android.synthetic.main.app.view.*
import net.apptronic.core.android.anim.animations.ViewAnimation_Fade
import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.bindings.bindClickListener
import net.apptronic.core.android.viewmodel.bindings.bindVisibleGone
import net.apptronic.core.android.viewmodel.bindings.navigation.bindNavigator
import net.apptronic.core.demoapp.R
import net.apptronic.core.demoapp.core.ui.AppViewModel
import net.apptronic.core.entity.function.isNotNull
import net.apptronic.core.viewmodel.navigation.models.viewModel

class AppViewBinder : ViewBinder<AppViewModel>() {

    override var layoutResId: Int? = R.layout.app

    override fun onBindView() {
        with(view) {
            bindNavigator(appContainer, viewModel.navigator)
            bindClickListener(fadeOverlay, viewModel::onTapOverlay)
            val isOverlayVisible = viewModel.overlayNavigator.content.viewModel().isNotNull()
            bindVisibleGone(fadeOverlay, isOverlayVisible) {
                enter = ViewAnimation_Fade
                exit = ViewAnimation_Fade.reversed()
            }
            bindNavigator(overlayContainer, viewModel.overlayNavigator)
        }
    }

}