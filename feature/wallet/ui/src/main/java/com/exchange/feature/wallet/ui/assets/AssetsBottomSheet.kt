package com.exchange.feature.wallet.ui.assets

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.wallet.ui.assets.component.HeaderCollapsed
import com.exchange.feature.wallet.ui.assets.component.HeaderExpanded


@Composable
fun AssetsBottomSheet(
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        AnimatedContent(
            targetState = expanded,
            label = "Expanded and collapsed Animation"
        ) { state ->
            if (state) {
                HeaderExpanded(
                    modifier = Modifier.padding(28.dp),
                    onCollapseClick = {
                        expanded = false
                    }
                )
            } else {
                HeaderCollapsed(
                    modifier = Modifier.padding(28.dp),
                    onExpandClick = {
                        expanded = true
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewAssetsBottomSheet() {
    ApplicationTheme {
        AssetsBottomSheet()
    }
}