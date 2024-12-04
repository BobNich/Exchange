package com.exchange.cloud.service.asset.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Asset(
    @SerialName("name")
    val name: String,
    @SerialName("code")
    val code: String
)
