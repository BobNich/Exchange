package com.exchange.cloud.service.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    @SerialName("username")
    val username: String,
    @SerialName("assets")
    val assets: List<AssetEntry>
)
