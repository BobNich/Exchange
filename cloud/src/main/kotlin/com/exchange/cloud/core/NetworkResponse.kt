package com.exchange.cloud.core

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    val data: T
)
