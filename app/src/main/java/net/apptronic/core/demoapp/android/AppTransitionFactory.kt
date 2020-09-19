package net.apptronic.core.demoapp.android

import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import net.apptronic.core.android.anim.factory.viewTransitionFactory
import net.apptronic.core.android.anim.transformations.alpha
import net.apptronic.core.android.anim.transformations.translateYToSelf
import net.apptronic.core.android.anim.transition.viewTransition
import net.apptronic.core.demoapp.core.ui.Transitions

/**
 * Single transition definition.
 */
val ViewTransition_SwitchBottomSheet = viewTransition {
    enter(DecelerateInterpolator()) {
        translateYToSelf(1f, 0f)
        alpha(0.5f, 1f)
    }
    exit(AccelerateInterpolator()) {
        translateYToSelf(0f, 1f)
        alpha(1f, 0.5f)
    }
}

/**
 * This object defines custom animation transitions when adding/removing/changing view
 */
val AppTransitionFactory = viewTransitionFactory {
    bindTransition(Transitions.ShowHideBottomSheet, ViewTransition_SwitchBottomSheet)
}