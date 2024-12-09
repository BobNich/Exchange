package com.exchange.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.exchange.feature.login.ui.Login
import com.exchange.feature.wallet.ui.Wallet
import com.exchange.navigation.ApplicationNavigation
import kotlinx.coroutines.launch


@Composable
fun ExchangeApp(
    authenticated: Boolean,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        ApplicationNavigation(
            navController = navController,
            onShowSnackbar = { message ->
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = message,
                        duration = Short,
                        withDismissAction = true
                    )
                }
            },
            startScreen = if (authenticated) {
                Wallet
            } else {
                Login
            },
            modifier = Modifier.padding(
                innerPadding
            )
        )
    }
}
