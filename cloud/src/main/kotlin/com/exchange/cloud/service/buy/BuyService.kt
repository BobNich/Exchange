package com.exchange.cloud.service.buy

import com.exchange.cloud.service.buy.model.BuyOffer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface BuyService {

    @POST("auth/token/refresh/")
    suspend fun buy(
        @Body buy: BuyOffer
    ): Response<Unit>
}
