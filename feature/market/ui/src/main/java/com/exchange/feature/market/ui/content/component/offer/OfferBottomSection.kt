package com.exchange.feature.market.ui.content.component.offer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.atom.text.JustText
import com.exchange.designsystem.components.text.SingleText
import com.exchange.feature.market.ui.R


@Composable
fun OfferBottomSection(
    username: String,
    buyCode: String,
    sellCode: String,
    available: String,
    limits: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            SingleText(
                text = JustText(
                    text = username,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Column(
                    Modifier.weight(0.3f)
                ) {
                    SingleText(
                        text = JustText(
                            text = stringResource(
                                id = R.string.offer_bottom_section_available_title
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SingleText(
                        text = JustText(
                            text = stringResource(
                                id = R.string.offer_bottom_section_limit_title
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }
                Column(
                    Modifier.weight(0.5f)
                ) {
                    SingleText(
                        text = JustText(
                            text = stringResource(
                                R.string.offer_bottom_section_available_value,
                                available,
                                sellCode
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SingleText(
                        text = JustText(
                            text = stringResource(
                                R.string.offer_bottom_section_limits_value,
                                limits,
                                buyCode
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }
            }
        }
    }
}
