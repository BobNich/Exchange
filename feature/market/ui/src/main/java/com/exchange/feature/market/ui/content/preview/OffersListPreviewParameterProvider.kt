package com.exchange.feature.market.ui.content.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

import com.exchange.feature.market.domain.CryptoOffer


class OffersListPreviewParameterProvider : PreviewParameterProvider<List<CryptoOffer>> {
    override val values = sequenceOf(OffersPreviewParameterData.offers)
}
