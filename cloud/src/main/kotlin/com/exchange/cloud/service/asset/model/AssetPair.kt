package com.exchange.cloud.service.asset.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AssetPair(
    @SerialName("buy")
    val buy: Asset,
    @SerialName("sell")
    val sell: Asset,
    @SerialName("price")
    val price: Float
)
