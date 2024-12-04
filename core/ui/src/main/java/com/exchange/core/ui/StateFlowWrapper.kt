package com.exchange.core.ui

import kotlinx.coroutines.flow.StateFlow

interface StateFlowWrapper {
    interface Update<T> {
        fun update(value: T)
    }

    interface Observe<T : Any> {
        fun state(): StateFlow<T>
    }

    interface Mutable<T : Any> : Update<T>, Observe<T>
}