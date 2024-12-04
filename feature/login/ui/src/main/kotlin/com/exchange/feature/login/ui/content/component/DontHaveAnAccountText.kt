package com.exchange.feature.login.ui.content.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.background.solidBackground
import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.atom.text.ClickableLinkText
import com.exchange.designsystem.components.text.MixedStyleText
import com.exchange.feature.login.ui.R


@Composable
fun DontHaveAnAccountTextAnimation(
    visible: Boolean,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = slideInVertically(
            initialOffsetY = { it }
        ) + fadeIn(),
        exit = slideOutVertically(
            targetOffsetY = { it }
        ) + fadeOut()
    ) {
        DontHaveAnAccountText(
            modifier = Modifier
                .padding(bottom = 20.dp),
            onSignUpClicked = onSignUpClicked,
        )
    }
}

@Composable
fun DontHaveAnAccountText(
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    MixedStyleText(
        modifier = modifier,
        parts = arrayOf(
            JustText(
                text = stringResource(
                    id = R.string.login_bottom_start
                ),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            ),
            ClickableLinkText(
                text = stringResource(
                    id = R.string.login_bottom_end
                ),
                style = MaterialTheme.typography.bodyMedium,
                brush = solidBackground(
                    color = MaterialTheme.colorScheme.primary
                ),
                onClick = onSignUpClicked,
                link = stringResource(
                    id = R.string.login_bottom_link
                ),
            )
        )
    )
}
