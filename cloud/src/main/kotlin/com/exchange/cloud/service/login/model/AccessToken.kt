package com.exchange.cloud.service.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    @SerialName("token")
    private val token: String,
)
