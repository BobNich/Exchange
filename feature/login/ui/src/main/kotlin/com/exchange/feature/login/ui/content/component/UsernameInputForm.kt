package com.exchange.feature.login.ui.content.component

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction

import com.exchange.designsystem.components.input.InputFormWithHint
import com.exchange.feature.login.ui.R
import com.exchange.feature.login.ui.interactor.username.UsernameUiState

@Composable
fun UsernameInputForm(
    uiState: UsernameUiState,
    onTextChanged: (String) -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    InputFormWithHint(
        text = uiState.text,
        modifier = modifier,
        onTextChanged = onTextChanged,
        enabled = enabled,
        hint = stringResource(
            id = R.string.login_username_input_hint
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
    )
}
