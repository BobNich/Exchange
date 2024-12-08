package com.exchange.feature.wallet.data

import com.exchange.feature.wallet.domain.GetUserWalletActionState
import com.exchange.feature.wallet.domain.GetUserWalletUseCase
import com.exchange.feature.wallet.domain.UserWalletRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class GetUserWalletUseCaseImpl @Inject constructor(
    private val repository: UserWalletRepository
) : GetUserWalletUseCase {
    override suspend fun invoke() = flow {
        emit(GetUserWalletActionState.Progress)
        val assets = repository.wallet()
        emit(GetUserWalletActionState.Success(assets))
    }.catch { error ->
        val message = error.message ?: error.toString()
        emit(GetUserWalletActionState.Failure(message))
    }
}
