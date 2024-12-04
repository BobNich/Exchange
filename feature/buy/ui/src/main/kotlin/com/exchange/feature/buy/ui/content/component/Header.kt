package com.exchange.feature.buy.ui.content.component

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
import com.exchange.feature.buy.ui.R


@Composable
fun Header(
    onBackClick: () -> Unit,
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
            onClick = onBackClick,
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.arrow_down_icon
                ),
                contentDescription = stringResource(
                    id = R.string.accessibility_go_to_market
                ),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        SingleText(
            modifier = Modifier.align(Alignment.Center),
            text = JustText(
                text = stringResource(
                    id = R.string.screen_name
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}
