package com.exchange.cloud.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StateTunnel {
    interface Observe<T : Any> {
        fun observe(): StateFlow<T>
    }

    interface Update<T : Any> {
        fun update(value: T)
    }

    interface Mutable<T : Any> : Update<T>, Observe<T>

    abstract class Abstract<T : Any>(
        initialState: T
    ) : Mutable<T> {
        private val state = MutableStateFlow(initialState)

        override fun observe(): StateFlow<T> {
            return state
        }

        override fun update(value: T) {
            state.value = value
        }
    }
}