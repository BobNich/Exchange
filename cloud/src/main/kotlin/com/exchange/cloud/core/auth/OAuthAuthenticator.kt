package com.exchange.cloud.core.auth

import com.exchange.cloud.service.login.LoginCloudDataSource
import com.exchange.cloud.service.login.model.RefreshToken
import com.exchange.core.network.ProvideToken
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class OAuthAuthenticator(
    private val provideRefreshToken: ProvideToken,
    private val loginCloudDataSource: LoginCloudDataSource
) : Authenticator {
    override fun authenticate(
        route: Route?,
        response: Response
    ): Request {
        val token = runCatching {
            runBlocking {
                loginCloudDataSource.refresh(
                    refresh = RefreshToken(
                        refresh = provideRefreshToken.provideToken()
                    )
                )
            }
        }.getOrNull()
        return response.request.newBuilder()
            .header(
                name = "Authorization",
                value = "Bearer $token"
            )
            .build()
    }
}
