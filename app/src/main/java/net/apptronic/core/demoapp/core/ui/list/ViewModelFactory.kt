package net.apptronic.core.demoapp.core.ui.list

import net.apptronic.core.mvvm.viewmodel.navigation.viewModelFactory

val ViewModelFactory = viewModelFactory {
    addBuilder(HeaderListItemViewModelBuilder)
    addBuilder(UserListItemViewModelBuilder)
    addBuilder(RobotListItemViewModelBuilder)
}