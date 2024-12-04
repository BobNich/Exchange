package com.exchange.feature.market.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class MarketViewModel @Inject constructor(

) : ViewModel() {
    private val uiState = MutableStateFlow<MarketUiState>(
        value = MarketUiState.Loading
    )

    fun uiState() = uiState
}
