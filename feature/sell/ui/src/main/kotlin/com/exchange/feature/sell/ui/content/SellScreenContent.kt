package com.exchange.feature.sell.ui.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.sell.ui.content.component.Header


@Composable
fun SellScreenContent(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            Header(
                modifier = Modifier
                    .padding(28.dp),
                onBackClick = onBackClicked
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewExchangeScreen() {
    ApplicationTheme {
        SellScreenContent(
            onBackClicked = {}
        )
    }
}
