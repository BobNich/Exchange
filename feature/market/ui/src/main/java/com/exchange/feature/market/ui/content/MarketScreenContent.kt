package com.exchange.feature.market.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.market.domain.CryptoOffer
import com.exchange.feature.market.ui.MarketUiState
import com.exchange.feature.market.ui.content.component.Header
import com.exchange.feature.market.ui.content.component.OffersContent
import com.exchange.feature.market.ui.content.preview.OffersListPreviewParameterProvider


@Composable
fun MarketScreenContent(
    uiState: MarketUiState,
    onBuyClick: (id: String) -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            Header(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        start = 20.dp
                    ),
                onClick = {
                    onBackClicked()
                }
            )

            when (uiState) {
                is MarketUiState.Loading,
                is MarketUiState.Failure -> Unit

                is MarketUiState.Success -> {
                    OffersContent(
                        offers = uiState.offers,
                        onBuyClick = onBuyClick
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewExchangeScreen(
    @PreviewParameter(OffersListPreviewParameterProvider::class)
    offers: List<CryptoOffer>
) {
    ApplicationTheme {
        MarketScreenContent(
            uiState = MarketUiState.Success(
                offers = offers
            ),
            onBackClicked = {},
            onBuyClick = {}
        )
    }
}
