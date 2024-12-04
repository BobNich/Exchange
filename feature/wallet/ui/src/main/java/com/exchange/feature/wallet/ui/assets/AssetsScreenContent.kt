package com.exchange.feature.wallet.ui.assets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.wallet.domain.UserAsset
import com.exchange.feature.wallet.ui.assets.component.list.AssetList


@Composable
fun AssetsScreenContent(
    assets: List<UserAsset>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            AssetList(
                assets = assets
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewAssetsScreenContent() {
    ApplicationTheme {
        AssetsScreenContent(
            assets = emptyList()
        )
    }
}
