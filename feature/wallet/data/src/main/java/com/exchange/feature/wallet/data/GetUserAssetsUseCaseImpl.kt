package com.exchange.feature.wallet.data

import com.exchange.feature.wallet.domain.GetUserWalletActionState
import com.exchange.feature.wallet.domain.GetUserWalletUseCase
import com.exchange.feature.wallet.domain.UserWalletRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class GetUserWalletUseCaseImpl @Inject constructor(
    private val repository: UserWalletRepository
) : GetUserWalletUseCase {
    override suspend fun invoke() = flow {
        emit(GetUserWalletActionState.Progress)
        while (true) {
            try {
                val assets = repository.wallet()
                emit(GetUserWalletActionState.Success(assets))
            } catch (error: Throwable) {
                val message = error.message ?: error.toString()
                emit(GetUserWalletActionState.Failure(message))
            }
            delay(RECHECK_WALLET_TIME_MILLIS)
        }
    }

    companion object {
        private const val RECHECK_WALLET_TIME_MILLIS = 3000L
    }
}
