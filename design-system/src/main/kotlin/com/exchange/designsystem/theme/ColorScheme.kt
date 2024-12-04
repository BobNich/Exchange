package com.exchange.designsystem.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.exchange.designsystem.theme.color.backgroundDark
import com.exchange.designsystem.theme.color.backgroundLight
import com.exchange.designsystem.theme.color.errorContainerDark
import com.exchange.designsystem.theme.color.errorContainerLight
import com.exchange.designsystem.theme.color.errorDark
import com.exchange.designsystem.theme.color.errorLight
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
import com.exchange.designsystem.theme.color.onTertiaryContainerDark
import com.exchange.designsystem.theme.color.onTertiaryContainerLight
import com.exchange.designsystem.theme.color.onTertiaryDark
import com.exchange.designsystem.theme.color.onTertiaryLight
import com.exchange.designsystem.theme.color.primaryContainerDark
import com.exchange.designsystem.theme.color.primaryContainerLight
import com.exchange.designsystem.theme.color.primaryDark
import com.exchange.designsystem.theme.color.primaryLight
import com.exchange.designsystem.theme.color.secondaryContainerDark
import com.exchange.designsystem.theme.color.secondaryContainerLight
import com.exchange.designsystem.theme.color.secondaryDark
import com.exchange.designsystem.theme.color.secondaryLight
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
)
