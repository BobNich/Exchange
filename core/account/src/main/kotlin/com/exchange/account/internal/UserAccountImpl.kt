package com.exchange.account.internal

import android.accounts.Account
import android.accounts.AccountManager
import com.exchange.account.UserAccount
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class UserAccountImpl @Inject constructor(
    private val accountManager: AccountManager
) : UserAccount {
    override fun deauthenticate() {
        accountManager.getAccountsByType(ACCOUNT_TYPE).forEach { account ->
            accountManager.removeAccountExplicitly(account)
        }
    }

    override fun authenticate(
        username: String,
        accessToken: String,
        refreshToken: String
    ) {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isEmpty()) {
            val account = Account(username, ACCOUNT_TYPE)
            accountManager.apply {
                addAccountExplicitly(account, null, null)
                setAuthToken(account, ACCESS_TOKEN_TYPE_NAME, accessToken)
                setAuthToken(account, REFRESH_TOKEN_TYPE_NAME, refreshToken)
            }
        }
    }

    override fun accessToken(): String {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isNotEmpty()) {
            val account = accounts.first()
            return accountManager.peekAuthToken(account, ACCESS_TOKEN_TYPE_NAME)
        } else {
            throw IllegalStateException()
        }
    }

    override fun refreshToken(): String {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isNotEmpty()) {
            val account = accounts.first()
            return accountManager.peekAuthToken(account, REFRESH_TOKEN_TYPE_NAME)
        } else {
            throw IllegalStateException()
        }
    }

    override fun authenticated(): Flow<Boolean> = flow {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        emit(accounts.isNotEmpty())
    }

    companion object {
        private const val ACCOUNT_TYPE = "com.exchange"
        private const val ACCESS_TOKEN_TYPE_NAME = "com.exchange.access"
        private const val REFRESH_TOKEN_TYPE_NAME = "com.exchange.refresh"
    }
}
