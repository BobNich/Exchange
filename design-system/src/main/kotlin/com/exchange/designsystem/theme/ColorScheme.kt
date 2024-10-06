package com.exchange.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.exchange.designsystem.theme.color.backgroundDark
import com.exchange.designsystem.theme.color.backgroundLight
import com.exchange.designsystem.theme.color.errorContainerDark
import com.exchange.designsystem.theme.color.errorContainerLight
import com.exchange.designsystem.theme.color.errorDark
import com.exchange.designsystem.theme.color.errorLight
import com.exchange.designsystem.theme.color.inverseOnSurfaceDark
import com.exchange.designsystem.theme.color.inverseOnSurfaceLight
import com.exchange.designsystem.theme.color.inversePrimaryDark
import com.exchange.designsystem.theme.color.inversePrimaryLight
import com.exchange.designsystem.theme.color.inverseSurfaceDark
import com.exchange.designsystem.theme.color.inverseSurfaceLight
import com.exchange.designsystem.theme.color.onBackgroundDark
import com.exchange.designsystem.theme.color.onBackgroundLight
import com.exchange.designsystem.theme.color.onErrorContainerDark
import com.exchange.designsystem.theme.color.onErrorContainerLight
import com.exchange.designsystem.theme.color.onErrorDark
import com.exchange.designsystem.theme.color.onErrorLight
import com.exchange.designsystem.theme.color.onPrimaryContainerDark
import com.exchange.designsystem.theme.color.onPrimaryContainerLight
import com.exchange.designsystem.theme.color.onPrimaryDark
import com.exchange.designsystem.theme.color.onPrimaryLight
import com.exchange.designsystem.theme.color.onSecondaryContainerDark
import com.exchange.designsystem.theme.color.onSecondaryContainerLight
import com.exchange.designsystem.theme.color.onSecondaryDark
import com.exchange.designsystem.theme.color.onSecondaryLight
import com.exchange.designsystem.theme.color.onSurfaceDark
import com.exchange.designsystem.theme.color.onSurfaceLight
import com.exchange.designsystem.theme.color.onSurfaceVariantDark
import com.exchange.designsystem.theme.color.onSurfaceVariantLight
import com.exchange.designsystem.theme.color.onTertiaryContainerDark
import com.exchange.designsystem.theme.color.onTertiaryContainerLight
import com.exchange.designsystem.theme.color.onTertiaryDark
import com.exchange.designsystem.theme.color.onTertiaryLight
import com.exchange.designsystem.theme.color.outlineDark
import com.exchange.designsystem.theme.color.outlineLight
import com.exchange.designsystem.theme.color.outlineVariantDark
import com.exchange.designsystem.theme.color.outlineVariantLight
import com.exchange.designsystem.theme.color.primaryContainerDark
import com.exchange.designsystem.theme.color.primaryContainerLight
import com.exchange.designsystem.theme.color.primaryDark
import com.exchange.designsystem.theme.color.primaryLight
import com.exchange.designsystem.theme.color.scrimDark
import com.exchange.designsystem.theme.color.scrimLight
import com.exchange.designsystem.theme.color.secondaryContainerDark
import com.exchange.designsystem.theme.color.secondaryContainerLight
import com.exchange.designsystem.theme.color.secondaryDark
import com.exchange.designsystem.theme.color.secondaryLight
import com.exchange.designsystem.theme.color.surfaceBrightDark
import com.exchange.designsystem.theme.color.surfaceBrightLight
import com.exchange.designsystem.theme.color.surfaceContainerDark
import com.exchange.designsystem.theme.color.surfaceContainerHighDark
import com.exchange.designsystem.theme.color.surfaceContainerHighLight
import com.exchange.designsystem.theme.color.surfaceContainerHighestDark
import com.exchange.designsystem.theme.color.surfaceContainerHighestLight
import com.exchange.designsystem.theme.color.surfaceContainerLight
import com.exchange.designsystem.theme.color.surfaceContainerLowDark
import com.exchange.designsystem.theme.color.surfaceContainerLowLight
import com.exchange.designsystem.theme.color.surfaceContainerLowestDark
import com.exchange.designsystem.theme.color.surfaceContainerLowestLight
import com.exchange.designsystem.theme.color.surfaceDark
import com.exchange.designsystem.theme.color.surfaceDimDark
import com.exchange.designsystem.theme.color.surfaceDimLight
import com.exchange.designsystem.theme.color.surfaceLight
import com.exchange.designsystem.theme.color.surfaceVariantDark
import com.exchange.designsystem.theme.color.surfaceVariantLight
import com.exchange.designsystem.theme.color.tertiaryContainerDark
import com.exchange.designsystem.theme.color.tertiaryContainerLight
import com.exchange.designsystem.theme.color.tertiaryDark
import com.exchange.designsystem.theme.color.tertiaryLight

internal val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

internal val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)
