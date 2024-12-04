package com.exchange.cloud.service.user.model

import com.exchange.cloud.service.asset.model.AssetEntry
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    @SerialName("username")
    val username: String,
    @SerialName("assets")
    val assets: List<AssetEntry>
)
