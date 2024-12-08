package com.exchange.feature.settings.data

import com.exchange.account.UserAccount
import com.exchange.feature.settings.domain.LogoutUseCase
import javax.inject.Inject


class LogoutUseCaseImpl @Inject constructor(
    private val userAccount: UserAccount
) : LogoutUseCase {
    override suspend fun invoke() {
        userAccount.deauthenticate()
    }
}
