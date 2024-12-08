package com.exchange.feature.wallet.ui.content.assets

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.exchange.feature.wallet.ui.content.assets.component.WalletProgress
import com.exchange.feature.wallet.ui.content.assets.component.list.AssetList
import com.exchange.feature.wallet.ui.content.assets.component.list.EmptyList
import com.exchange.feature.wallet.ui.interactor.wallet.WalletUiState


@Composable
fun AssetsScreenContent(
    uiState: WalletUiState,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        modifier = modifier,
        targetState = uiState,
        label = "wallet-animation"
    ) { state ->
        Box {
            when (state) {
                is WalletUiState.Loading -> {
                    WalletProgress(
                        modifier = Modifier.align(
                            alignment = Alignment.Center
                        )
                    )
                }

                is WalletUiState.Success -> {
                    if (state.isEmpty()) {
                        EmptyList(
                            modifier = Modifier.align(
                                alignment = Alignment.Center
                            )
                        )
                    } else {
                        AssetList(
                            modifier = Modifier
                                .padding(
                                    top = 20.dp,
                                    bottom = 20.dp,
                                    start = 20.dp,
                                    end = 28.dp
                                ),
                            assets = state.assets
                        )
                    }
                }
            }
        }
    }
}
