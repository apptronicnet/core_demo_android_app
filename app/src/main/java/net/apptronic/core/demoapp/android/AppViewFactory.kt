package net.apptronic.core.demoapp.android

import net.apptronic.core.android.viewmodel.AndroidView
import net.apptronic.core.android.viewmodel.AndroidViewFactory
import net.apptronic.core.android.viewmodel.androidViewFactory
import net.apptronic.core.demoapp.android.view.*
import net.apptronic.core.mvvm.viewmodel.ViewModel

/**
 * This [AndroidViewFactory] contains all bindings between [ViewModel] and [AndroidView] for whole app.
 * It needed to add each new [AndroidView] binding here.
 */
val AppViewFactory = androidViewFactory {
    addBinding(::AppView)
    addBinding(::WelcomeView)
    addBinding(::LoginView)
    addBinding(::IncorrectCredentialsDialogView)
    addBinding(::DataListView)
    addBinding(::HeaderListItemView)
    addBinding(::RobotListItemView)
    addBinding(::UserListItemView)
}