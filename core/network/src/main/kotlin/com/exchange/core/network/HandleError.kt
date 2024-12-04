package com.exchange.core.network

interface HandleError<S : Any, E : Any> {
    fun handle(source: S): E
}
