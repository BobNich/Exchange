package com.exchange.feature.wallet.ui.assets.component.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.exchange.feature.wallet.domain.UserAsset
import com.exchange.feature.wallet.ui.R


@Composable
fun AssetList(
    assets: List<UserAsset>,
    modifier: Modifier = Modifier
) {
    val listSize by remember {
        mutableIntStateOf(assets.size)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val lazyListState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(20.dp),
            state = lazyListState
        ) {
            assets.forEachIndexed { index, asset ->
                val assetId = asset.name
                item(key = assetId) {
                    AssetItem(
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp
                            ),
                        name = asset.name,
                        code = asset.code,
                        balance = asset.amount.toString(),
                        // todo(implement)
                        icon = R.drawable.account_icon
                    )
                    if (index + 1 != listSize) {
                        AssetListDivider()
                    }
                }
            }
        }
    }
}
