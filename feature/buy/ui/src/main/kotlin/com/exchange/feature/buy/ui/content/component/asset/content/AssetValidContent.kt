package com.exchange.feature.buy.ui.content.component.asset.content

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ReceiveAssetValidValue(
    value: String,
    code: String,
    modifier: Modifier = Modifier
) {
    AssetContentComponent(
        modifier = modifier,
        value = value,
        code = code,
        color = MaterialTheme.colorScheme.onSecondary
    )
}
