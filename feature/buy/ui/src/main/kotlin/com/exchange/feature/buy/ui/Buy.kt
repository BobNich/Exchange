package com.exchange.feature.buy.ui

import com.exchange.core.ui.Screen
import kotlinx.serialization.Serializable


@Serializable
data class Buy(val offerId: String) : Screen
