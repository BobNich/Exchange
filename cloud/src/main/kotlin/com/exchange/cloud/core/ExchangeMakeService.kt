package com.exchange.cloud.core

import com.exchange.core.network.MakeService
import com.exchange.core.network.ProvideBaseUrl
import com.exchange.core.network.ProvideRetrofitBuilder

class ExchangeMakeService(
    retrofitBuilder: ProvideRetrofitBuilder,
    baseUrl: ProvideBaseUrl
) : MakeService.Abstract(retrofitBuilder, baseUrl)
