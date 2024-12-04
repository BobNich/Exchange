package com.exchange.navigation.flow

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
    navController: NavController
) {
    composable<Market> {
        MarketRoute(
            viewModel = hiltViewModel(),
            navigateToBuy = {
                // TODO(navigate with parameter $id)
            },
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
    composable<Buy> {
        BuyRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
    composable<Sell> {
        SellRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}
