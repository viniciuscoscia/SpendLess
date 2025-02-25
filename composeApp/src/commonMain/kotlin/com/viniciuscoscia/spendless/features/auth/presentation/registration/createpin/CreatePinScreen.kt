package com.viniciuscoscia.spendless.features.auth.presentation.registration.createpin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.viniciuscoscia.spendless.core.presentation.common.OnPrimaryFixed
import com.viniciuscoscia.spendless.core.presentation.common.PrimaryFixed
import com.viniciuscoscia.spendless.core.presentation.common.components.SubtitleText
import com.viniciuscoscia.spendless.core.presentation.common.components.TitleText
import com.viniciuscoscia.spendless.core.presentation.common.components.WalletIcon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.backspace_icon
import spendless.composeapp.generated.resources.create_pin_screen_subtitle
import spendless.composeapp.generated.resources.create_pin_screen_title

@Composable
fun CreatePinScreen() {
    Scaffold(
        topBar = {
            Button(
                modifier = Modifier.padding(
                    vertical = 16.dp,
                    horizontal = 8.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackButton()

            WalletIcon()

            TitleText(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(Res.string.create_pin_screen_title)
            )

            SubtitleText(
                text = stringResource(Res.string.create_pin_screen_subtitle)
            )

            PinEntry()
        }
    }
}

@Composable
private fun BackButton() {

}

@Composable
private fun PinEntry() {
    var pin by remember { mutableStateOf("") }
    val maxPinLength = 5

    val disabledPinEntries by remember {
        derivedStateOf {
            maxPinLength - pin.length
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = 16.dp
            )
        ) {
            repeat(pin.length) {
                PinCircle(color = MaterialTheme.colorScheme.primary)
            }

            repeat(disabledPinEntries) {
                PinCircle(color = MaterialTheme.colorScheme.onBackground.copy(0.12f))
            }
        }

        NumericKeyboard(
            onNumberClick = { number ->
                if (pin.length < maxPinLength) {
                    pin += number.toString()
                }
            },
            onDeleteClick = {
                if (pin.isNotEmpty()) {
                    pin = pin.dropLast(1)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun PinCircle(color: Color) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(18.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
private fun NumericKeyboard(
    onNumberClick: (Int) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val numbers = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
        listOf(null, 0, -1)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        numbers.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { number ->
                    Box(
                        modifier = Modifier.weight(1f)
                            .size(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        when (number) {
                            null -> Spacer(modifier = Modifier.fillMaxWidth())
                            -1 -> Button( // Backspace
                                onClick = onDeleteClick,
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.textButtonColors(
                                    containerColor = PrimaryFixed.copy(alpha = 0.1f)
                                )
                            ) {
                                Image(
                                    modifier = Modifier.size(36.dp),
                                    painter = painterResource(Res.drawable.backspace_icon),
                                    contentDescription = ""
                                )
                            }

                            else -> TextButton(
                                onClick = { onNumberClick(number) },
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.textButtonColors(
                                    containerColor = PrimaryFixed.copy(alpha = 0.8f),
                                    contentColor = OnPrimaryFixed
                                )
                            ) {
                                Text(
                                    text = number.toString(),
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
