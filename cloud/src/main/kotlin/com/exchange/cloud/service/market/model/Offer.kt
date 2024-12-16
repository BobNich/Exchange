package com.exchange.cloud.service.market.model

import com.exchange.cloud.service.asset.model.Asset
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Offer(
    @SerialName("id")
    val id: Int,
    @SerialName("seller")
    val seller: Seller,
    @SerialName("sell_asset")
    val sellAsset: Asset,
    @SerialName("buy_asset")
    val buyAsset: Asset,
    @SerialName("min_amount")
    val minAmount: Float,
    @SerialName("max_amount")
    val maxAmount: Float,
    @SerialName("price")
    val price: Float,
    @SerialName("created_at")
    val createdAt: String
)
