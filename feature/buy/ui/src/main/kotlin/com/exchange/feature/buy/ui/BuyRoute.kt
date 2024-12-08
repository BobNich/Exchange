package com.exchange.feature.buy.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exchange.feature.buy.ui.content.BuyScreenContent


@Composable
fun BuyRoute(
    viewModel: BuyViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BuyScreenContent(
        onBuyClick = {},
        onValueChanged = {},
        onBackClick = navigateBack,
        enabled = false
    )
}
