package com.exchange.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.exchange.core.ui.Screen

import com.exchange.navigation.flow.marketFlow
import com.exchange.navigation.flow.startFlow
import com.exchange.navigation.flow.walletFlow


@Composable
fun ApplicationNavigation(
    navController: NavHostController,
    startScreen: Screen,
    onShowSnackbar: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startScreen,
    ) {
        startFlow(
            navController = navController,
            onShowSnackbar = onShowSnackbar
        )
        walletFlow(navController)
        marketFlow(navController)
    }
}
