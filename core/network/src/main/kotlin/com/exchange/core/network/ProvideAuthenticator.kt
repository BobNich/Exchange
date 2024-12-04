package com.exchange.core.network

import okhttp3.Authenticator

interface ProvideAuthenticator {

    fun authenticator(): Authenticator

}