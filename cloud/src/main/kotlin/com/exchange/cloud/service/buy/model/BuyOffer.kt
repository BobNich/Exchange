package com.exchange.cloud.service.buy.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuyOffer(
    @SerialName("id")
    private val id: String,
    @SerialName("amount")
    private val amount: Float,
)