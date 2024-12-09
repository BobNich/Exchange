package com.exchange.feature.market.ui.content.preview

import com.exchange.core.domain.CryptoOffer


object OffersPreviewParameterData {

    val offers = listOf(
        CryptoOffer(
            id = "1",
            sellerUsername = "Bob Nicholson",
            price = 200f,
            sellAssetCode = "ETH",
            buyAssetCode = "BTC",
            availableAmount = 200f,
            maximumAmount = 20f,
            minimumAmount = 1f
        ),
        CryptoOffer(
            id = "2",
            sellerUsername = "Ilana Bastard",
            price = 100f,
            sellAssetCode = "ETH",
            buyAssetCode = "BTC",
            availableAmount = 200f,
            maximumAmount = 20f,
            minimumAmount = 1f
        ),
        CryptoOffer(
            id = "3",
            sellerUsername = "Janie Johnson",
            price = 100f,
            sellAssetCode = "ETH",
            buyAssetCode = "BTC",
            availableAmount = 200f,
            maximumAmount = 20f,
            minimumAmount = 1f
        ),
    )

}