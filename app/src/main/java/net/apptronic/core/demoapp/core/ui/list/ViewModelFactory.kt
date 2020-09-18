package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.mvvm.viewmodel.navigation.DynamicListNavigator
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelBuilder
import net.apptronic.core.mvvm.viewmodel.navigation.ViewModelFactory
import net.apptronic.core.mvvm.viewmodel.navigation.plus

/**
 * When needed to use several item types inside of [DynamicListNavigator] there is possibility to create
 * "combo" [ViewModelBuilder]: class [ViewModelFactory], which combine any number of [ViewModelBuilder] objects
 * to generic [ViewModelBuilder] which supports all types, specified in inner [ViewModelBuilder]s.
 */
val ViewModelFactory =
    HeaderListItemViewModelBuilder + UserListItemViewModelBuilder + RobotListItemViewModelBuilder
