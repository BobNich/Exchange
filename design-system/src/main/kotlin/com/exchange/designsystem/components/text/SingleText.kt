package com.exchange.designsystem.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exchange.designsystem.atom.text.TextAtom


@Composable
fun SingleText(
    text: TextAtom,
    modifier: Modifier = Modifier,
) {
    MixedStyleText(
        parts = arrayOf(text),
        modifier = modifier
    )
}
