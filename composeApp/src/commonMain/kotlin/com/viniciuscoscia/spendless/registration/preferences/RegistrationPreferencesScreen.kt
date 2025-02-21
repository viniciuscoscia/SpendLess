package com.viniciuscoscia.spendless.registration.preferences

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viniciuscoscia.spendless.core.presentation.common.OnPrimaryFixed
import com.viniciuscoscia.spendless.core.presentation.common.components.BackButton
import com.viniciuscoscia.spendless.core.presentation.common.components.SubtitleText
import com.viniciuscoscia.spendless.core.presentation.common.components.TitleText
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.currency
import spendless.composeapp.generated.resources.decimal_separator
import spendless.composeapp.generated.resources.expenses_format
import spendless.composeapp.generated.resources.registration_preferences_subtitle
import spendless.composeapp.generated.resources.registration_preferences_title
import spendless.composeapp.generated.resources.spent_this_month
import spendless.composeapp.generated.resources.start_tracking
import spendless.composeapp.generated.resources.thousands_separator

@Composable
fun RegistrationPreferencesScreen() {
    Scaffold(
        topBar = {
            BackButton(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    )
            ) {
                // TODO
            }
        },
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(
                modifier = Modifier.size(88.dp)
            )

            TitleText(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(),
                text = stringResource(Res.string.registration_preferences_title),
                textAlign = TextAlign.Start
            )

            SubtitleText(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = stringResource(Res.string.registration_preferences_subtitle)
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
                ),
                modifier = Modifier
                    .height(height = 120.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "-$10,382.45",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(
                        modifier = Modifier.size(4.dp)
                    )

                    Text(
                        text = stringResource(Res.string.spent_this_month),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }

            SettingLabel(
                text = stringResource(Res.string.expenses_format)
            )
            SingleChoiceSegmentedButton()

            SettingLabel(
                text = stringResource(Res.string.currency)
            )
            CurrencyDropdown()

            SettingLabel(
                text = stringResource(Res.string.decimal_separator)
            )
            SingleChoiceSegmentedButton()

            SettingLabel(
                text = stringResource(Res.string.thousands_separator)
            )
            SingleChoiceSegmentedButton()

            StartTrackingButton()
        }
    }
}

@Composable
private fun StartTrackingButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 32.dp,
                bottom = 24.dp
            ).height(48.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {

        },
        content = {
            Text(
                text = stringResource(Res.string.start_tracking)
            )
        }
    )
}

@Composable
private fun SettingLabel(text: String) {
    Text(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        style = MaterialTheme.typography.labelSmall,
        fontSize = 14.sp,
        text = text
    )
}

data class Currency(
    val symbol: String,
    val name: String,
    val code: String
)

@Composable
fun CurrencyDropdown() {
    val currencies = listOf(
        Currency("$", "US Dollar", "USD"),
        Currency("€", "Euro", "EUR"),
        Currency("£", "British Pound Sterling", "GBP"),
        Currency("¥", "Japanese Yen", "JPY"),
        Currency("CHF", "Swiss Franc", "CHF")
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember { mutableStateOf(currencies.first()) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ElevatedButton(
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            ),
            modifier = Modifier.fillMaxWidth()
                .height(48.dp),
            onClick = {
                expanded = !expanded
            },
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 2.dp
            ),
            shape = AbsoluteRoundedCornerShape(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row {
                    Text(
                        text = selectedCurrency.symbol,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "${selectedCurrency.name} (${selectedCurrency.code})",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentDescription = ""
                )
            }
        }

        DropdownMenu(
            modifier = Modifier
                .width(this@BoxWithConstraints.maxWidth),
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            currencies.forEach { currency ->
                DropdownMenuItem(
                    text = { Text("${currency.symbol} ${currency.name} (${currency.code})") },
                    onClick = { selectedCurrency = currency }
                )
            }
        }
    }
}

@Composable
fun SingleChoiceSegmentedButton(
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Day", "Month", "Week")

    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.08f),
            shape = AbsoluteRoundedCornerShape(16.dp)
        ).fillMaxWidth()
            .height(48.dp),
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(all = 4.dp),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) },
                colors = SegmentedButtonDefaults.colors(
                    activeBorderColor = Color.Transparent,
                    inactiveBorderColor = Color.Transparent,
                    activeContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                    inactiveContainerColor = Color.Transparent,
                    activeContentColor = MaterialTheme.colorScheme.onSurface,
                    inactiveContentColor = OnPrimaryFixed
                ),
                icon = {}
            )
        }
    }
}