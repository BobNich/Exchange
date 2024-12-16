package com.exchange.navigation.flow

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.exchange.feature.buy.ui.Buy
import com.exchange.feature.buy.ui.BuyRoute
import com.exchange.feature.market.ui.Market
import com.exchange.feature.market.ui.MarketRoute
import com.exchange.feature.sell.ui.Sell
import com.exchange.feature.sell.ui.SellRoute


fun NavGraphBuilder.marketFlow(
    navController: NavController,
    onShowSnackbar: (String) -> Unit,
    navigateSafely: (() -> Unit) -> Unit,
) {
    composable<Market>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(durationMillis = 300)
            ) + fadeOut(animationSpec = tween(100))
        }
    ) {
        MarketRoute(
            viewModel = hiltViewModel(),
            navigateToBuy = { offer ->
                navigateSafely {
                    navController.navigate(
                        Buy(
                            offerId = offer.id,
                            price = offer.price,
                            sellCode = offer.sellAssetCode,
                            buyCode = offer.buyAssetCode,
                            minimumAmount = offer.minimumAmount,
                            maximumAmount = offer.maximumAmount
                        )
                    )
                }
            },
            navigateBack = {
                navigateSafely {
                    navController.popBackStack()
                }
            }
        )
    }
    composable<Buy>(
        enterTransition = {
            slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
        }
    ) {
        BuyRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navigateSafely {
                    navController.popBackStack()
                }
            },
            onShowSnackbar = onShowSnackbar
        )
    }
    composable<Sell>(
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(100))
        },
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(durationMillis = 300)
            ) + fadeOut(animationSpec = tween(100))
        }
    ) {
        SellRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navigateSafely {
                    navController.popBackStack()
                }
            }
        )
    }
}
