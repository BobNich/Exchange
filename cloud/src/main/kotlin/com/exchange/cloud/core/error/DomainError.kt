package com.exchange.cloud.core.error

import retrofit2.HttpException
import retrofit2.Response

abstract class DomainError : Throwable()

data class ServiceUnavailableError(override val message: String) : DomainError()

data class NoInternetConnectionError(override val message: String) : DomainError()

data class RefusedConnectionError(override val message: String) : DomainError()

data class ServiceTemporaryError(private val response: Response<*>) : HttpException(response)

data class TooManyRequestsError(private val response: Response<*>) : HttpException(response)

data class BadRequestError(private val response: Response<*>) : HttpException(response)

data class UnknownHttpError(private val response: Response<*>) : HttpException(response)