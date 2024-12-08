package com.exchange.feature.wallet.ui.content.wallet.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.wallet.ui.R


@Composable
fun Header(
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tint by remember {
        mutableStateOf(Color(0xFF904503))
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.wallet_icon
                ),
                tint = tint,
                contentDescription = null
            )
            SingleText(
                text = JustText(
                    text = stringResource(
                        id = R.string.main_screen_title
                    ),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }
        IconButton(
            onClick = onProfileClick,
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.account_icon
                ),
                tint = tint,
                contentDescription = stringResource(
                    id = R.string.accessibility_go_to_account
                )
            )
        }
    }
}
