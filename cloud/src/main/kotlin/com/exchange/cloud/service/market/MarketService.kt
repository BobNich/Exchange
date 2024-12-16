package com.exchange.cloud.service.market

import com.exchange.cloud.service.market.model.Offer
import retrofit2.Response
import retrofit2.http.GET


interface MarketService {

    @GET("orders/")
    suspend fun orders(): Response<List<Offer>>

}
