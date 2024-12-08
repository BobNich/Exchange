package com.exchange.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel(
    private val dispatchers: DispatchersList
) : ViewModel(), Handle {

    override fun <T : Any> async(
        block: suspend () -> T,
        ui: (T) -> Unit
    ) = viewModelScope.launch(dispatchers.io()) {
        val result = block.invoke()
        withContext(dispatchers.ui()) {
            ui.invoke(result)
        }
    }

    override fun <T : Any> async(
        block: suspend () -> T
    ): Job = viewModelScope.launch(dispatchers.io()) {
        block.invoke()
    }
}

interface Handle {
    fun <T : Any> async(
        block: suspend () -> T,
        ui: (T) -> Unit
    ): Job

    fun <T : Any> async(
        block: suspend () -> T,
    ): Job
}
