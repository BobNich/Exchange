package com.exchange.feature.wallet.domain


sealed interface GetUserAssetsActionState {
    data object Progress : GetUserAssetsActionState

    data class Success(
        val list: List<UserAsset>
    ) : GetUserAssetsActionState

    data class Failure(
        val message: String
    ) : GetUserAssetsActionState
}
