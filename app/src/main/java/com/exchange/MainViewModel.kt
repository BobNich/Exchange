package com.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exchange.account.UserAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    userAccount: UserAccount
) : ViewModel() {
    private val uiState = userAccount.authenticated().map {
        MainActivityUiState.Success(it)
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = MainActivityUiState.Loading
        )

    fun uiState() = uiState
}

sealed interface MainActivityUiState {
    fun authenticated(): Boolean

    data object Loading : MainActivityUiState {
        override fun authenticated() = false
    }

    data class Success(
        private val authenticated: Boolean
    ) : MainActivityUiState {
        override fun authenticated() = authenticated
    }
}
