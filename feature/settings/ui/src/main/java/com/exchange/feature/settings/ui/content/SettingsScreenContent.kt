package com.exchange.feature.settings.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.settings.ui.content.component.Header
import com.exchange.feature.settings.ui.content.component.PreferencesSection
import com.exchange.feature.settings.ui.content.component.Profile


@Composable
fun SettingsScreenContent(
    username: String,
    onLogoutClick: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            Header(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        start = 20.dp
                    ),
                onClick = {
                    onBackClicked()
                }
            )
            Profile(
                modifier = Modifier
                    .padding(
                        top = 36.dp
                    ),
                username = username
            )
            PreferencesSection(
                modifier = Modifier
                    .padding(
                        top = 36.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                onLogoutClick = {
                    onLogoutClick()
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewSettingsScreenContentScreen() {
    ApplicationTheme {
        SettingsScreenContent(
            username = "Bob",
            onBackClicked = {},
            onLogoutClick = {}
        )
    }
}
