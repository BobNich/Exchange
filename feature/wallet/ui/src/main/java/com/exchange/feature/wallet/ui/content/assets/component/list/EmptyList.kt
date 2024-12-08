package com.exchange.feature.wallet.ui.content.assets.component.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.wallet.ui.R


@Composable
fun EmptyList(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.empty_wallet_icon
            ),
            contentDescription = null
        )
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.no_assets_title
                ),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}