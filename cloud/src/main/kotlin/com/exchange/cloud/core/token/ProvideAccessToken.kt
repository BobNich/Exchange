package com.exchange.cloud.core.token

import com.exchange.account.UserAccount
import com.exchange.core.network.ProvideToken


class ProvideAccessToken(
    private val userAccount: UserAccount
): ProvideToken {
    override fun provideToken(): String {
        return userAccount.accessToken()
    }
}
