package com.exchange.cloud.service.user

import com.exchange.cloud.service.user.model.UserProfile
import retrofit2.Response
import retrofit2.http.GET

interface ProfileService {

    @GET("users/profile/")
    suspend fun profile(): Response<UserProfile>

}
