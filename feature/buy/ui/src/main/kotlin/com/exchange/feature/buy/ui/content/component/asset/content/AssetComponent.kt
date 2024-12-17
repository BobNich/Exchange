package com.exchange.feature.buy.ui.content.component.asset.content

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.designsystem.components.text.MixedStyleText
import com.exchange.designsystem.theme.font.fontFamily


@Composable
fun AssetComponent(
    title: String,
    color: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 30.dp))
            .background(color = color)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SingleText(
                modifier = Modifier.weight(1f),
                text = JustText(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )

            Box(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                content()
            }
        }
    }
}

@Composable
fun AssetContentComponent(
    value: String,
    code: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    MixedStyleText(
        modifier = modifier,
        parts = arrayOf(
            JustText(
                text = "$value ",
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 36.sp
                ),
                color = color
            ),
            JustText(
                text = code,
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp
                ),
                color = color
            )
        )
    )
}
