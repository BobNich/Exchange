package com.exchange.core.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class AbstractStateFlowWrapper<T : Any>(
    initialState: T
) : Flowable.Mutable<T> {

    private val state = MutableStateFlow(initialState)

    override fun state(): StateFlow<T> {
        return state
    }

    override fun update(value: T) {
        state.value = value
    }
}