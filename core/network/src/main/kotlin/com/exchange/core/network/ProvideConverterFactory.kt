package com.exchange.core.network

import retrofit2.Converter

interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory

}
