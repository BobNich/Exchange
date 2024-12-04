package com.exchange.feature.buy.ui.content.component.asset.content

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ReceiveAssetHint(
    from: String,
    to: String,
    code: String,
    modifier: Modifier = Modifier
) {
    AssetContentComponent(
        modifier = modifier,
        value = "$from – $to",
        code = code,
        color = MaterialTheme.colorScheme.onSecondary.copy(
            alpha = 0.5f
        )
    )
}
