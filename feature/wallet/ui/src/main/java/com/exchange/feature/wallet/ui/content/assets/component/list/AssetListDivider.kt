package com.exchange.feature.wallet.ui.content.assets.component.list

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AssetListDivider(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = 0.5.dp,
        color = MaterialTheme.colorScheme.onSecondaryContainer,
    )
}
