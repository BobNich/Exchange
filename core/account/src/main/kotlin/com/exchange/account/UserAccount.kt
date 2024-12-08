package com.exchange.account

import kotlinx.coroutines.flow.Flow


interface UserAccount {

    fun deauthenticate()

    fun authenticate(
        username: String,
        accessToken: String,
        refreshToken: String
    )

    fun updateTokens(
        accessToken: String,
        refreshToken: String
    )

    fun username(): String

    fun accessToken(): String

    fun refreshToken(): String

    fun authenticated(): Boolean

    fun authenticatedFlow(): Flow<Boolean>
}
