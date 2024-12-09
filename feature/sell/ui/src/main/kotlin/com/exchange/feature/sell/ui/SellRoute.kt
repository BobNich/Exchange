package com.exchange.feature.sell.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exchange.feature.sell.ui.content.SellScreenContent


@Composable
fun SellRoute(
    viewModel: SellViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    SellScreenContent(
        onBackClicked = navigateBack,
        onValueChanged = {

        },
        onSellClick = {

        },
        enabled = false,
    )
}
