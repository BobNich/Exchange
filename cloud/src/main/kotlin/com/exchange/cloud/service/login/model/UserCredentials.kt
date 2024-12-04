package com.exchange.cloud.service.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCredentials(
    @SerialName("username")
    private val username: String,
    @SerialName("password")
    private val password: String
)
