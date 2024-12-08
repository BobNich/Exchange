package com.exchange.feature.wallet.domain

interface GetUsernameUseCase {

    suspend operator fun invoke(): String

}