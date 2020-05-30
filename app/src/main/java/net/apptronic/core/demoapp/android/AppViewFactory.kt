package net.apptronic.core.demoapp.android

import net.apptronic.core.android.viewmodel.androidViewFactory
import net.apptronic.core.demoapp.android.view.*

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