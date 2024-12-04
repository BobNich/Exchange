package com.exchange.cloud.service.login

import com.exchange.cloud.service.login.model.AccessRefreshTokens
import com.exchange.cloud.service.login.model.AccessToken
import com.exchange.cloud.service.login.model.RefreshToken
import com.exchange.cloud.service.login.model.UserCredentials
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @POST("auth/token/")
    @Headers("Authentication: true")
    suspend fun login(
        @Body credentials: UserCredentials
    ): Response<AccessRefreshTokens>

    @POST("auth/token/refresh/")
    suspend fun refresh(
        @Body refresh: RefreshToken
    ): Response<AccessRefreshTokens>

    @POST("auth/token/refresh/")
    suspend fun verify(
        @Body token: AccessToken
    ): Response<Unit>
}
