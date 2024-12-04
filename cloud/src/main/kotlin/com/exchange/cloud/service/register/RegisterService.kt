package com.exchange.cloud.service.register

import com.exchange.cloud.service.login.model.UserCredentials
import com.exchange.cloud.service.register.model.RegistrationConfirm
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {

    @POST("auth/register/")
    suspend fun register(
        @Body credentials: UserCredentials
    ): Response<RegistrationConfirm>
}
