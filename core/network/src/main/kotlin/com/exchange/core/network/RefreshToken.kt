package com.exchange.core.network


interface RefreshToken {

    fun refresh(token: String): String

}
