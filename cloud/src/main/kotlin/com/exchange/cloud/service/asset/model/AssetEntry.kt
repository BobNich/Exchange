package com.exchange.cloud.service.asset.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssetEntry(
    @SerialName("asset")
    val asset: Asset,
    @SerialName("amount")
    val amount: Float
)
