package com.exchange.navigation.flow

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

import com.exchange.feature.login.ui.Login
import com.exchange.feature.login.ui.LoginRoute
import com.exchange.feature.signup.ui.Signup
import com.exchange.feature.signup.ui.SignupRoute


fun NavGraphBuilder.startFlow(
    navController: NavController,
    navigateSafely: (() -> Unit) -> Unit,
    onShowSnackbar: (String) -> Unit
) {
    composable<Login>(
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(100))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(100))
        }
    ) {
        LoginRoute(
            viewModel = hiltViewModel(),
            navigateToSignUp = {
                navigateSafely {
                    navController.navigate(Signup)
                }
            },
            onShowSnackbar = onShowSnackbar
        )
    }
    composable<Signup>(
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
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeIn(animationSpec = tween(100))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            ) + fadeOut(animationSpec = tween(100))
        }
    ) {
        SignupRoute(
            viewModel = hiltViewModel(),
            navigateBack = {
                navigateSafely {
                    navController.popBackStack()
                }
            },
            onShowSnackbar = onShowSnackbar
        )
    }
}
