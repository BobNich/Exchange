package com.exchange.designsystem.modifier

import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * The Material3 guidelines tell us to use the default minimum component sizes.
 * Sometimes we may need to override this behavior. Use it with caution.
 */
@Stable
fun Modifier.removeSizeConstraints(): Modifier {
    return this.requiredSizeIn(
        minWidth = 1.dp, minHeight = 1.dp
    )
}
