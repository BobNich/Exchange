package com.exchange.navigation.flow

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.exchange.feature.login.ui.Login
import com.exchange.feature.market.ui.Market
import com.exchange.feature.sell.ui.Sell
import com.exchange.feature.settings.ui.Settings
import com.exchange.feature.settings.ui.SettingsRoute
import com.exchange.feature.wallet.ui.Wallet
import com.exchange.feature.wallet.ui.WalletRoute


fun NavGraphBuilder.walletFlow(
    navController: NavController,
    navigateSafely: (() -> Unit) -> Unit,
) {
    composable<Wallet>(
        enterTransition = {
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 300)
            ) + scaleIn(
                initialScale = 0.95f,
                animationSpec = tween(durationMillis = 300)
            ) + fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 300)
            ) + fadeOut(animationSpec = tween(100))
        }
    ) {
        WalletRoute(
            viewModel = hiltViewModel(),
            navigateToSettings = {
                navigateSafely {
                    navController.navigate(Settings)
                }
            },
            navigateToMarket = {
                navigateSafely {
                    navController.navigate(Market)
                }
            },
            navigateToSell = {
                navigateSafely {
                    navController.navigate(Sell)
                }
            }
        )
    }
    composable<Settings>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(100))
        }
    ) {
        SettingsRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navigateSafely {
                    navController.popBackStack()
                }
            },
            navigateToLogin = {
                navigateSafely {
                    navController.navigate(Login) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                            saveState = false
                        }
                    }
                }
            },
        )
    }
}
