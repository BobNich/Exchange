package com.exchange.cloud.service.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessRefreshTokens(
    @SerialName("access")
    val accessToken: String,
    @SerialName("refresh")
    val refreshToken: String,
)
