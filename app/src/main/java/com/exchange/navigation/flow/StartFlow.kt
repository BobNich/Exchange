package com.exchange.navigation.flow

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

import com.exchange.feature.login.ui.Login
import com.exchange.feature.login.ui.LoginRoute
import com.exchange.feature.wallet.ui.Wallet
import com.exchange.feature.signup.ui.Signup
import com.exchange.feature.signup.ui.SignupRoute


fun NavGraphBuilder.startFlow(
    navController: NavController,
    onShowSnackbar: (String) -> Unit
) {
    composable<Login> {
        LoginRoute(
            viewModel = hiltViewModel(),
            navigateToSignUp = {
                navController.navigate(Signup)
            },
            navigateToWallet = {
                navController.navigate(
                    route = Wallet,
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(
                            route = Login,
                            inclusive = true
                        ).build()
                )
            },
            onShowSnackbar = onShowSnackbar
        )
    }
    composable<Signup> {
        SignupRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}
