package com.exchange.feature.buy.ui.content.component.asset.pay

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.feature.buy.ui.R
import com.exchange.feature.buy.ui.content.component.asset.content.AssetComponent

@Composable
fun PayAsset(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AssetComponent(
        modifier = modifier,
        title = stringResource(
            id = R.string.asset_pay_title
        ),
        color = MaterialTheme.colorScheme.primaryContainer,
        content = content
    )
}
