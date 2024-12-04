package com.exchange.feature.signup.ui.content.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.atom.text.BrushedText
import com.exchange.designsystem.components.color.ExchangeGradient
import com.exchange.designsystem.components.text.MixedStyleText
import com.exchange.feature.signup.ui.R


@Composable
fun Title(
    modifier: Modifier = Modifier
) {
    MixedStyleText(
        modifier = modifier,
        parts = arrayOf(
            JustText(
                text = stringResource(
                    id = R.string.signup_title_start
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            ),
            BrushedText(
                text = stringResource(
                    id = R.string.signup_title_end
                ),
                style = MaterialTheme.typography.titleMedium,
                brush = ExchangeGradient.primaryLinear
            )
        )
    )
}
