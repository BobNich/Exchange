package com.exchange.feature.settings.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exchange.feature.settings.ui.content.SettingsScreenContent


@Composable
fun SettingsRoute(
    viewModel: SettingsViewModel,
    navigateBack: () -> Unit,
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    SettingsScreenContent(
        modifier = modifier,
        onLogoutClick = {
            viewModel.logout()
            navigateToLogin()
        },
        onBackClicked = {
            navigateBack()
        }
    )
}
