package com.exchange.feature.buy.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.exchange.designsystem.theme.font.fontFamily
import com.exchange.feature.buy.ui.content.component.BuyButton
import com.exchange.feature.buy.ui.content.component.Keyboard


@Composable
fun BuyKeyboard(
    maxValue: Float,
    onBuyClick: () -> Unit,
    enabled: Boolean,
    onFormattedValueChange: (String) -> Unit,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
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
                .padding(top = 20.dp),
            maxValue = maxValue,
            onValueChange = onValueChange,
            onFormattedValueChange = onFormattedValueChange,
            textStyle = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp
            ),
            itemShape = RoundedCornerShape(
                size = 8.dp
            )
        )
        BuyButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = onBuyClick,
            enabled = enabled
        )
    }
}
