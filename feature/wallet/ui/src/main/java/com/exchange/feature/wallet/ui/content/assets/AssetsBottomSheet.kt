package com.exchange.feature.wallet.ui.content.assets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

import com.exchange.feature.wallet.ui.content.assets.component.HeaderCollapsed
import com.exchange.feature.wallet.ui.content.assets.component.HeaderExpanded
import com.exchange.feature.wallet.ui.content.assets.component.button.ShowAllButton
import com.exchange.feature.wallet.ui.content.assets.component.button.ShowLessButton
import com.exchange.feature.wallet.ui.interactor.wallet.WalletUiState


@Composable
fun AssetsBottomSheet(
    uiState: WalletUiState,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    BottomSheetContainer(
        modifier = modifier
            .fillMaxSize(),
        expanded = expanded
    ) {
        Column {
            AssetsHeader(
                modifier = Modifier
                    .padding(
                        top = 28.dp,
                        start = 28.dp,
                        end = 28.dp
                    ),
                isExpanded = expanded,
                toggle = {
                    expanded = expanded.not()
                }
            )

            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                AssetsScreenContent(
                    modifier = Modifier
                        .fillMaxSize(),
                    uiState = uiState,
                )
            }

            AssetsBottomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 28.dp
                    ),
                isExpanded = expanded,
                onClick = {
                    expanded = expanded.not()
                },
            )
        }
    }
}

@Composable
fun BottomSheetContainer(
    expanded: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    val animatedCorners by animateDpAsState(
        targetValue = if (expanded) 0.dp else 45.dp,
        animationSpec = tween(
            durationMillis = 600,
            easing = LinearOutSlowInEasing
        ),
        label = "Corner Animation"
    )

    val animatedHeightFraction by animateFloatAsState(
        targetValue = if (expanded) 1f else 0.5f,
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        ),
        label = "Height Animation"
    )

    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        val maxHeight = maxHeight

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    height = maxHeight * animatedHeightFraction
                )
                .clip(
                    shape = RoundedCornerShape(
                        topStart = animatedCorners,
                        topEnd = animatedCorners
                    )
                )
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        ) {
            content()
        }
    }
}

@Composable
fun AssetsHeader(
    isExpanded: Boolean,
    toggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedContent(
        modifier = modifier,
        targetState = isExpanded,
        label = "assets-header-expand-collapse"
    ) { expanded ->
        if (expanded) {
            HeaderExpanded(
                onCollapseClick = toggle
            )
        } else {
            HeaderCollapsed(
                onExpandClick = toggle
            )
        }
    }
}

@Composable
fun AssetsBottomButton(
    isExpanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isExpanded) {
        ShowLessButton(
            modifier = modifier,
            onClick = onClick
        )
    } else {
        ShowAllButton(
            modifier = modifier,
            onClick = onClick
        )
    }
}
