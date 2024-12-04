package com.exchange.cloud.service.asset

import com.exchange.cloud.service.asset.model.AssetPair
import retrofit2.Response
import retrofit2.http.GET

interface PairsService {

    @GET("assets/pairs/")
    suspend fun pairs(): Response<List<AssetPair>>

}
