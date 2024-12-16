package com.exchange.feature.buy.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.exchange.core.ui.EventConsumer
import com.exchange.feature.buy.ui.content.BuyScreenContent


@Composable
fun BuyRoute(
    viewModel: BuyViewModel,
    navigateBack: () -> Unit,
    onShowSnackbar: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val offer by viewModel
        .offer
        .collectAsStateWithLifecycle()

    val session by viewModel
        .session
        .collectAsStateWithLifecycle()

    EventConsumer(
        channel = viewModel.toastEventChannel()
    ) { message ->
        onShowSnackbar(message)
    }

    EventConsumer(
        channel = viewModel.goBackEventChannel()
    ) {
        navigateBack()
    }

    BuyScreenContent(
        offer = offer,
        session = session,
        onValueChange = { value ->
            viewModel.process(
                value = value,
                offer = offer,
            )
        },
        onBuyClick = {
            viewModel.buy(
                amount = session.value
            )
        },
        onBackClick = navigateBack,
    )
}
