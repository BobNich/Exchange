package com.exchange.cloud.service.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshToken(
    @SerialName("refresh")
    private val refresh: String,
)
