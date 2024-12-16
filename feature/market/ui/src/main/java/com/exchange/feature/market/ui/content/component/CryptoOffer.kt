package com.exchange.feature.market.ui.content.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

import com.exchange.feature.market.ui.content.component.offer.OfferBottomSection
import com.exchange.feature.market.ui.content.component.offer.OfferTopSection


@Composable
fun Offer(
    onBuyClick: () -> Unit,
    sellerUsername: String,
    price: String,
    buyCode: String,
    sellCode: String,
    limits: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(
                    size = 10.dp
                )
            )
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
    ) {
        OfferTopSection(
            modifier = Modifier
                .padding(20.dp),
            price = price,
            buyCode = buyCode,
            sellCode = sellCode,
            onBuyClick = onBuyClick
        )
        HorizontalDivider(
            thickness = 0.5.dp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        OfferBottomSection(
            modifier = Modifier.padding(20.dp),
            username = sellerUsername,
            sellCode = sellCode,
            limits = limits
        )
    }
}
