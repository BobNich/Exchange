package com.exchange.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
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
            onShowSnackbar = onShowSnackbar,
            navigateSafely = { navigate ->
                if (navController.lifecycleIsResumed()) {
                    navigate()
                }
            }
        )
        walletFlow(
            navController = navController,
            navigateSafely = { navigate ->
                if (navController.lifecycleIsResumed()) {
                    navigate()
                }
            }
        )
        marketFlow(
            navController = navController,
            onShowSnackbar = onShowSnackbar,
            navigateSafely = { navigate ->
                if (navController.lifecycleIsResumed()) {
                    navigate()
                }
            }
        )
    }
}

private fun NavController.lifecycleIsResumed() =
    this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED