package com.exchange.feature.login.ui.content.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.button.LoadableExchangeButton
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.login.ui.R


@Composable
fun SignInButton(
    onClick: () -> Unit,
    loading: Boolean,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    LoadableExchangeButton(
        modifier = modifier,
        onClick = {
            focusManager.clearFocus()
            onClick()
        },
        loading = loading,
        background = MaterialTheme.colorScheme.primaryContainer
    ) {
        SingleText(
            text = JustText(
                text = stringResource(
                    id = R.string.login_sign_in_button
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}
