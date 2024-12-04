package com.exchange.designsystem.components.input

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.R
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText


@Composable
fun PasswordInputForm(
    text: String,
    onTextChanged: (String) -> Unit,
    enabled: Boolean = true,
    hint: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    modifier: Modifier = Modifier,
) {
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    TextField(
        modifier = modifier,
        value = text,
        enabled = enabled,
        placeholder = {
            SingleText(
                text = JustText(
                    text = hint,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else PasswordVisualTransformation(),
        keyboardOptions = keyboardOptions.copy(
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = keyboardActions,
        onValueChange = { new ->
            onTextChanged(new)
        },
        textStyle = MaterialTheme.typography.titleSmall,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = MaterialTheme.colorScheme.secondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {
                Icon(
                    painter = painterResource(
                        id = if (passwordVisible) {
                            R.drawable.ic_eye_open
                        } else {
                            R.drawable.ic_eye_closed
                        }
                    ),
                    contentDescription = stringResource(
                        id = if (passwordVisible) {
                            R.string.accessibility_password_visible
                        } else {
                            R.string.accessibility_password_not_visible
                        }
                    )
                )
            }
        }
    )
}
