package com.exchange.feature.buy.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.exchange.feature.buy.ui.content.component.asset.content.AssetValidValue
import com.exchange.feature.buy.ui.content.component.asset.pay.PayAsset
import com.exchange.feature.buy.ui.content.component.asset.receive.ReceiveAsset


@Composable
fun PayReceive(
    payAmount: String,
    payCode: String,
    receiveAmount: String,
    receiveCode: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ReceiveAsset {
            AssetValidValue(
                value = receiveAmount,
                code = receiveCode
            )
        }
        PayAsset {
            AssetValidValue(
                value = payAmount,
                code = payCode
            )
        }
    }
}
