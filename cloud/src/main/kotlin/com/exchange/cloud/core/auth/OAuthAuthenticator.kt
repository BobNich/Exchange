package com.exchange.cloud.core.auth

import com.exchange.account.UserAccount
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
    private val loginCloudDataSource: LoginCloudDataSource,
    private val userAccount: UserAccount
) : Authenticator {
    private val Response.responseCount: Int
        get() = generateSequence(this) { it.priorResponse }.count()

    override fun authenticate(
        route: Route?,
        response: Response
    ): Request? {
        if (response.responseCount >= MAX_ATTEMPTS) {
            userAccount.deauthenticate()
            return null
        }
        val token = tryRefreshToken() ?: return null
        val access = token.accessToken
        val refresh = token.refreshToken
        userAccount.updateTokens(
            accessToken = access,
            refreshToken = refresh
        )
        return response.request.newBuilder()
            .header("Authorization", "Bearer $access")
            .build()
    }

    private fun tryRefreshToken() = runCatching {
        runBlocking {
            loginCloudDataSource.refresh(
                refresh = RefreshToken(
                    refresh = provideRefreshToken.provideToken()
                )
            )
        }
    }.getOrNull()

    companion object {
        private const val MAX_ATTEMPTS = 3
    }
}
