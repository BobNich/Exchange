package com.exchange.feature.login.ui.content.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.designsystem.components.input.PasswordInputForm
import com.exchange.feature.login.ui.R
import com.exchange.feature.login.ui.interactor.password.PasswordUiState


@Composable
fun LoginPasswordInputForm(
    uiState: PasswordUiState,
    onTextChanged: (String) -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    PasswordInputForm(
        text = uiState.text,
        modifier = modifier,
        onTextChanged = onTextChanged,
        enabled = enabled,
        hint = stringResource(
            id = R.string.login_password_input_hint
        )
    )
}
