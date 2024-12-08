package com.exchange.feature.buy.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.designsystem.theme.font.fontFamily
import com.exchange.feature.buy.ui.content.component.BuyButton
import com.exchange.feature.buy.ui.content.component.Header
import com.exchange.feature.buy.ui.content.component.Keyboard


@Composable
fun BuyScreenContent(
    onBackClick: () -> Unit,
    onValueChanged: (Double) -> Unit,
    onBuyClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(
                top = 20.dp
            )
    ) {
        Header(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(28.dp),
            onBackClick = onBackClick
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 45.dp,
                        topEnd = 45.dp
                    )
                )
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        ) {
            Keyboard(
                modifier = Modifier
                    .padding(
                        top = 20.dp
                    ),
                onValueChange = onValueChanged,
                onFormattedValueChanged = {

                },
                textStyle = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 32.sp
                ),
                itemShape = RoundedCornerShape(size = 8.dp)
            )
            BuyButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 44.dp,
                        horizontal = 20.dp
                    ),
                onClick = onBuyClick,
                enabled = enabled
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewExchangeScreen() {
    ApplicationTheme {
        BuyScreenContent(
            onBackClick = {},
            onBuyClick = {},
            onValueChanged = {},
            enabled = false
        )
    }
}
