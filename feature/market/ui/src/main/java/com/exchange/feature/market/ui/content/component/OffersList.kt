package com.exchange.feature.market.ui.content.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.exchange.core.domain.CryptoOffer
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.market.ui.R


@Composable
fun OffersContent(
    offers: List<CryptoOffer>,
    onBuyClick: (offer: CryptoOffer) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (offers.isEmpty()) {
            NoOffersAvailable(
                modifier = Modifier.align(
                    alignment = Alignment.Center
                ),
            )
        } else {
            OffersList(
                offers = offers,
                onBuyClick = onBuyClick
            )
        }
    }
}

@Composable
fun NoOffersAvailable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.no_offers_found_title
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.no_offers_found_title2
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}

@Composable
fun OffersList(
    offers: List<CryptoOffer>,
    onBuyClick: (offer: CryptoOffer) -> Unit,
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
                        onBuyClick = { onBuyClick(offer) },
                        sellerUsername = offer.sellerUsername,
                        price = offer.price.toString(),
                        buyCode = offer.buyAssetCode,
                        sellCode = offer.sellAssetCode,
                        limits = "${offer.minimumAmount} – ${offer.maximumAmount}"
                    )
                }
            }
        }
    }
}