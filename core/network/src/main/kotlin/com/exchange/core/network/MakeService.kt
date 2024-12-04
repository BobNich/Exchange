package com.exchange.core.network

interface MakeService {

    fun <T : Any> service(clazz: Class<T>): T

    abstract class Abstract(
        private val retrofitBuilder: ProvideRetrofitBuilder,
        private val baseUrl: ProvideBaseUrl
    ) : MakeService {

        private val retrofit by lazy {
            retrofitBuilder.provideRetrofitBuilder()
                .baseUrl(baseUrl.provideBaseUrl())
                .build()
        }

        override fun <T : Any> service(clazz: Class<T>): T = retrofit.create(clazz)
    }
}
