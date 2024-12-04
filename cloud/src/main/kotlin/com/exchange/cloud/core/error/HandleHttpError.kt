package com.exchange.cloud.core.error

import com.exchange.core.network.HandleError
import retrofit2.Response

class HandleHttpError : HandleError<Response<*>, Throwable> {

    override fun handle(source: Response<*>): Throwable =
        when (source.code()) {
            BAD_REQUEST_CODE -> BadRequestError(source)
            TOO_MANY_REQUESTS_CODE -> TooManyRequestsError(source)
            in SERVICE_ERRORS_CODES_RANGE -> ServiceTemporaryError(source)
            else -> UnknownHttpError(source)
        }

    companion object {
        private const val BAD_REQUEST_CODE = 400
        private const val TOO_MANY_REQUESTS_CODE = 429
        private val SERVICE_ERRORS_CODES_RANGE = 500..600
    }
}
