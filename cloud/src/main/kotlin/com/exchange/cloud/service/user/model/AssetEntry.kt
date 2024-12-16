package com.exchange.cloud.service.user.model

import com.exchange.cloud.service.market.model.Asset
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AssetEntry(
    @SerialName("asset")
    val asset: Asset,
    @SerialName("amount")
    val amount: Float
)
