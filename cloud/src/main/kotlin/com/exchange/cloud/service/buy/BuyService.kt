package com.exchange.cloud.service.buy

import com.exchange.cloud.service.buy.model.BuyOffer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path


interface BuyService {

    @POST("orders/{id}/complete/")
    suspend fun buy(
        @Path("id") id: String,
        @Body buy: BuyOffer
    ): Response<Unit>

}
