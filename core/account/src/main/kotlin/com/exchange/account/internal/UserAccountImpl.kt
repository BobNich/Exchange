package com.exchange.account.internal

import android.accounts.Account
import android.accounts.AccountManager
import com.exchange.account.UserAccount
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


internal class UserAccountImpl @Inject constructor(
    private val accountManager: AccountManager
) : UserAccount {

    private val authenticated = MutableStateFlow(
        value = authenticated()
    )

    init {
        accountManager.addOnAccountsUpdatedListener(
            { authenticated.value = authenticated() },
            null,
            false
        )
    }

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
            val account = Account(ACCOUNT_NAME, ACCOUNT_TYPE)
            accountManager.apply {
                addAccountExplicitly(account, null, null)
                setUserData(account, USERNAME_TYPE_NAME, username)
                setAuthToken(account, ACCESS_TOKEN_TYPE_NAME, accessToken)
                setAuthToken(account, REFRESH_TOKEN_TYPE_NAME, refreshToken)
            }
        } else {
            accounts.forEach { account ->
                accountManager.removeAccountExplicitly(account)
            }
            authenticate(
                username = username,
                accessToken = accessToken,
                refreshToken = refreshToken
            )
        }
    }

    override fun updateTokens(accessToken: String, refreshToken: String) {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isNotEmpty()) {
            val account = accounts.first()
            accountManager.apply {
                setAuthToken(account, ACCESS_TOKEN_TYPE_NAME, accessToken)
                setAuthToken(account, REFRESH_TOKEN_TYPE_NAME, refreshToken)
            }
        } else {
            throw IllegalStateException()
        }
    }

    override fun username(): String {
        val accounts = accountManager.getAccountsByType(ACCOUNT_TYPE)
        if (accounts.isNotEmpty()) {
            val account = accounts.first()
            return accountManager.getUserData(account, USERNAME_TYPE_NAME)
        } else {
            throw IllegalStateException()
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

    override fun authenticated() =
        accountManager.getAccountsByType(ACCOUNT_TYPE).isNotEmpty()

    override fun authenticatedFlow() = authenticated

    companion object {
        private const val ACCOUNT_NAME = "Exchange ID"
        private const val ACCOUNT_TYPE = "com.exchange"
        private const val USERNAME_TYPE_NAME = "com.exchange.username"
        private const val ACCESS_TOKEN_TYPE_NAME = "com.exchange.access"
        private const val REFRESH_TOKEN_TYPE_NAME = "com.exchange.refresh"
    }
}
