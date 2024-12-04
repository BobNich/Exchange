package com.exchange.account

import kotlinx.coroutines.flow.Flow


interface UserAccount {

    fun deauthenticate()

    fun authenticate(
        username: String,
        accessToken: String,
        refreshToken: String
    )

    fun accessToken(): String

    fun refreshToken(): String

    fun authenticated(): Flow<Boolean>
}
