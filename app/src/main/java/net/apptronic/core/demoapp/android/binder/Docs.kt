package net.apptronic.core.demoapp.android.binder

/**
 * This package contains UI bindings between framework [ViewModel] and android [View] classes.
 *
 * The [ViewBinder.layoutResId] declares a layout file to be used for inflating [View].
 *
 * The [ViewBinder.onBindView] contains binding between [View] and [ViewModel]. Here it is possible
 * to use binding extension methods or write binding code by:
 * - subscribing to [Entity] inside [ViewModel] and updating [View] state
 * - updating [Entity] and invoking [ViewModel] methods.
 * Remember that subscription management for [Entity] is automatic, so manual unsubscribing is not
 * needed.
 */
