package com.exchange.cloud.core.converter

import com.exchange.core.network.ProvideConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class JsonConverterFactory : ProvideConverterFactory {
    override fun converterFactory(): Converter.Factory {
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory("application/json".toMediaType())
    }
}
