package com.exchange.cloud.service.register.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationConfirm(
    @SerialName("username")
    val username: String
)