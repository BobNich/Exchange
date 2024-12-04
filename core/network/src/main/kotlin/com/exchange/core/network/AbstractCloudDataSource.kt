package com.exchange.core.network

import retrofit2.HttpException
import retrofit2.Response

abstract class AbstractCloudDataSource(
    private val errorHandler: HandleError<Exception, Throwable>
) {
    protected suspend fun <T : Any> handle(
        block: suspend () -> Response<T>
    ): T = try {
        val response = block.invoke()
        if (response.isSuccessful) response.body()!!
        else throw HttpException(response)
    } catch (e: Exception) {
        throw errorHandler.handle(e)
    }
}