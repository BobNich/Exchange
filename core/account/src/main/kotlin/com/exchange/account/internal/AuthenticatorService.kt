package com.exchange.account.internal

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder

internal class AuthenticatorService : Service() {

    private lateinit var authenticator: Authenticator

    private class Authenticator(context: Context) : AbstractAccountAuthenticator(context) {
        override fun editProperties(
            response: AccountAuthenticatorResponse?,
            accountType: String?
        ): Bundle? {
            return null
        }

        override fun addAccount(
            response: AccountAuthenticatorResponse?,
            accountType: String?,
            authTokenType: String?,
            requiredFeatures: Array<out String>?,
            options: Bundle?
        ): Bundle? {
            return null
        }

        override fun confirmCredentials(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            options: Bundle?
        ): Bundle? {
            return null
        }

        override fun getAuthToken(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            authTokenType: String?,
            options: Bundle?
        ): Bundle? {
            return null
        }

        override fun getAuthTokenLabel(
            authTokenType: String?
        ): String? {
            return null
        }

        override fun updateCredentials(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            authTokenType: String?,
            options: Bundle?
        ): Bundle? {
            return null
        }

        override fun hasFeatures(
            response: AccountAuthenticatorResponse?,
            account: Account?,
            features: Array<out String>?
        ): Bundle? {
            return null
        }
    }

    override fun onCreate() {
        super.onCreate()
        authenticator = Authenticator(this)
    }

    override fun onBind(intent: Intent?): IBinder? {
        intent?.let {
            if (it.action == AccountManager.ACTION_AUTHENTICATOR_INTENT) {
                return authenticator.iBinder
            }
        }
        return null
    }
}