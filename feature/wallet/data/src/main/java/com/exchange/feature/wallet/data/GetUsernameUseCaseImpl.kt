package com.exchange.feature.wallet.data

import com.exchange.account.UserAccount
import com.exchange.feature.wallet.domain.GetUsernameUseCase
import javax.inject.Inject


class GetUsernameUseCaseImpl @Inject constructor(
    private val userAccount: UserAccount
): GetUsernameUseCase {
    override suspend fun invoke(): String {
        return userAccount.username()
    }
}
