package com.exchange.feature.market.ui.content.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exchange.core.domain.CryptoOffer


@Composable
fun OffersContent(
    offers: List<CryptoOffer>,
    onBuyClick: (id: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val lazyListState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(20.dp),
            state = lazyListState
        ) {
            offers.forEach { offer ->
                val offerId = offer.id
                item(key = offerId) {
                    Offer(
                        modifier = Modifier
                            .padding(bottom = 12.dp),
                        onBuyClick = { onBuyClick(offerId) },
                        sellerUsername = offer.sellerUsername,
                        price = offer.price.toString(),
                        buyCode = offer.buyAssetCode,
                        sellCode = offer.sellAssetCode,
                        available = offer.availableAmount.toString(),
                        limits = "${offer.minimumAmount} – ${offer.maximumAmount}"
                    )
                }
            }
        }
    }
}
