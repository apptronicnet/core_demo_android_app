package net.apptronic.core.demoapp.android

import net.apptronic.core.android.viewmodel.ViewBinder
import net.apptronic.core.android.viewmodel.ViewBinderFactory
import net.apptronic.core.android.viewmodel.viewBinderFactory
import net.apptronic.core.demoapp.android.binder.*
import net.apptronic.core.mvvm.viewmodel.ViewModel

/**
 * This [ViewBinderFactory] contains all bindings between [ViewModel] and [ViewBinder] for whole app.
 * It needed to add each new [ViewBinder] binding here.
 */
val AppBinderFactory = viewBinderFactory {
    add(::AppViewBinder)
    add(::WelcomeViewBinder)
    add(::LoginViewBinder)
    add(::IncorrectCredentialsDialogBinder)
    add(::DataListViewBinder)
    add(::HeaderListItemViewBinder)
    add(::RobotListItemViewBinder)
    add(::UserListItemViewBinder)
}