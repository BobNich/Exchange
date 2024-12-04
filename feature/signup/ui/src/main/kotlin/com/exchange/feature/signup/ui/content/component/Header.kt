package com.exchange.feature.signup.ui.content.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import com.exchange.feature.signup.ui.R


@Composable
fun Header(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Icon(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() },
        painter = painterResource(
            id = R.drawable.ic_back
        ),
        tint = MaterialTheme.colorScheme.onBackground,
        contentDescription = stringResource(
            id = R.string.accessibility_go_back_to_login
        )
    )
}
