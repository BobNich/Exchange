package com.exchange.feature.wallet.data

import com.exchange.feature.wallet.domain.GetUserAssetsActionState
import com.exchange.feature.wallet.domain.GetUserAssetsUseCase
import com.exchange.feature.wallet.domain.UserAssetsRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class GetUserAssetsUseCaseImpl @Inject constructor(
    private val repository: UserAssetsRepository
) : GetUserAssetsUseCase {
    override suspend fun invoke() = flow {
        emit(GetUserAssetsActionState.Progress)
        val assets = repository.assets()
        emit(GetUserAssetsActionState.Success(assets))
    }.catch { error ->
        val message = error.message ?: error.toString()
        emit(GetUserAssetsActionState.Failure(message))
    }
}
