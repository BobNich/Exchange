package com.exchange.feature.sell.ui.content

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
import com.exchange.feature.sell.ui.content.component.Header
import com.exchange.feature.sell.ui.content.component.Keyboard
import com.exchange.feature.sell.ui.content.component.SellButton


@Composable
fun SellScreenContent(
    onBackClicked: () -> Unit,
    onValueChanged: (Double) -> Unit,
    onSellClick: () -> Unit,
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
        Column(
            modifier = Modifier.padding(
                top = 28.dp
            )
        ) {
            Header(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp
                    ),
                onBackClick = onBackClicked
            )
        }
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
            SellButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                onClick = onSellClick,
                enabled = enabled
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewExchangeScreen() {
    ApplicationTheme {
        SellScreenContent(
            onBackClicked = {},
            onValueChanged = {},
            onSellClick = {},
            enabled = true,
        )
    }
}
