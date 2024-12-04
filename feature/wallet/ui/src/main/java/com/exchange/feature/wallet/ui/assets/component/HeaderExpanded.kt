package com.exchange.feature.wallet.ui.assets.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.wallet.ui.R


@Composable
fun HeaderExpanded(
    onCollapseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        IconButton(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart),
            onClick = onCollapseClick,
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.arrow_down_icon
                ),
                contentDescription = stringResource(
                    id = R.string.accessibility_expand_assets
                ),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        SingleText(
            modifier = Modifier.align(Alignment.Center),
            text = JustText(
                text = stringResource(
                    id = R.string.assets_screen_title
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}
