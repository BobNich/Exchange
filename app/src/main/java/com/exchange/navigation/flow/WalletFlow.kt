package com.exchange.navigation.flow

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

import com.exchange.feature.login.ui.Login
import com.exchange.feature.market.ui.Market
import com.exchange.feature.sell.ui.Sell
import com.exchange.feature.settings.ui.Settings
import com.exchange.feature.settings.ui.SettingsRoute
import com.exchange.feature.wallet.ui.Wallet
import com.exchange.feature.wallet.ui.WalletRoute


fun NavGraphBuilder.walletFlow(
    navController: NavController
) {
    composable<Wallet> {
        WalletRoute(
            viewModel = hiltViewModel(),
            navigateToSettings = {
                navController.navigate(Settings)
            },
            navigateToMarket = {
                navController.navigate(Market)
            },
            navigateToSell = {
                navController.navigate(Sell)
            }
        )
    }
    composable<Settings> {
        SettingsRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navController.popBackStack()
            },
            navigateToLogin = {
                navController.navigate(
                    route = Login,
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(
                            route = Settings,
                            inclusive = true
                        ).build()
                )
            },
        )
    }
}
