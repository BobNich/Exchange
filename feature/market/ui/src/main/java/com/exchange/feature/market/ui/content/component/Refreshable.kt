package com.exchange.feature.market.ui.content.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Refreshable(
    refreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var firstRefresh by rememberSaveable {
        mutableStateOf(false)
    }

    val refreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        modifier = modifier,
        state = refreshState,
        isRefreshing = refreshing && firstRefresh,
        indicator = {
            Indicator(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.TopCenter),
                isRefreshing = refreshing,
                state = refreshState
            )
        },
        onRefresh = {
            firstRefresh = true
            onRefresh()
        },
    ) {
        content()
    }
}
