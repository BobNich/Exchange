package com.exchange.feature.buy.data

import com.exchange.cloud.service.buy.BuyCloudDataSource
import com.exchange.cloud.service.buy.model.BuyOffer
import com.exchange.feature.buy.domain.BuyActionState
import com.exchange.feature.buy.domain.BuyRequest
import com.exchange.feature.buy.domain.BuyUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class BuyUseCaseImpl @Inject constructor(
    private val buyCloudDataSource: BuyCloudDataSource
): BuyUseCase {
    override suspend fun invoke(
        request: BuyRequest
    ) = flow {
        emit(BuyActionState.Progress)
        buyCloudDataSource.buy(
            buy = BuyOffer(
                id = request.offerId,
                amount = request.amount
            )
        )
        emit(BuyActionState.Success)
    }.catch { error ->
        val message = error.message ?: error.toString()
        emit(BuyActionState.Failure(message))
    }
}
