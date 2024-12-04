package com.exchange.designsystem.atom.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp


@Composable
fun CoreButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape,
    background: Brush,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val containerColor = Color.Transparent
    val contentColor = Color.Unspecified
    Surface(
        onClick = onClick,
        modifier = modifier.semantics { role = Role.Button },
        enabled = enabled,
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 0.dp,
        border = null,
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(
                    minWidth = ExchangeButtonDefaults.MinWidth,
                    minHeight = ExchangeButtonDefaults.MinHeight
                )
                .background(
                    brush = background,
                    shape = shape
                )
                .padding(contentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
        }
    }
}

internal object ExchangeButtonDefaults {
    val MinWidth = 58.dp
    val MinHeight = 54.dp
}
