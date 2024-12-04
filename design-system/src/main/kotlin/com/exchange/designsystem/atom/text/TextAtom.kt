package com.exchange.designsystem.atom.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle

import com.exchange.designsystem.atom.background.solidBackground


interface TextAtom {
    @Composable
    fun AnnotatedString(builder: AnnotatedString.Builder)
}

class JustText(
    private val text: String,
    private val style: TextStyle,
    private val color: Color
) : TextAtom {
    @Composable
    override fun AnnotatedString(
        builder: AnnotatedString.Builder
    ) {
        builder.apply {
            withStyle(
                style = style.toSpanStyle().copy(
                    brush = solidBackground(
                        color = color
                    )
                )
            ) {
                append(text)
            }
        }
    }
}

class BrushedText(
    private val text: String,
    private val style: TextStyle,
    private val brush: Brush
) : TextAtom {
    @Composable
    override fun AnnotatedString(
        builder: AnnotatedString.Builder
    ) {
        builder.apply {
            withStyle(
                style = style.toSpanStyle().copy(
                    brush = brush
                )
            ) {
                append(text)
            }
        }
    }
}

class ClickableLinkText(
    private val text: String,
    private val link: String,
    private val style: TextStyle,
    private val brush: Brush,
    private val onClick: () -> Unit
) : TextAtom {
    @Composable
    override fun AnnotatedString(
        builder: AnnotatedString.Builder
    ) {
        builder.apply {
            val link = LinkAnnotation.Url(
                url = link,
                styles = TextLinkStyles(
                    style = style.toSpanStyle().copy(
                        brush = brush
                    ),
                    pressedStyle = style.toSpanStyle().copy(
                        brush = brush,
                        alpha = 0.5f
                    ),
                )
            ) {
                onClick()
            }
            withLink(link) {
                append(text)
            }
        }
    }
}
