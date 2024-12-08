package com.exchange.feature.market.data

import com.exchange.feature.market.domain.CryptoOffersRepository
import com.exchange.feature.market.domain.GetCryptoOffersActionState
import com.exchange.feature.market.domain.GetCryptoOffersUseCase

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCryptoOffersUseCaseImpl @Inject constructor(
    private val repository: CryptoOffersRepository
): GetCryptoOffersUseCase {
    override suspend fun invoke() = flow {
        emit(GetCryptoOffersActionState.Progress)
        val assets = repository.offers()
        emit(GetCryptoOffersActionState.Success(assets))
    }.catch { error ->
        val message = error.message ?: error.toString()
        emit(GetCryptoOffersActionState.Failure(message))
    }
}
