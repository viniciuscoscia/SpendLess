package com.viniciuscoscia.spendless.core.presentation.registration.preferences

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
import spendless.composeapp.generated.resources.start_tracking
import spendless.composeapp.generated.resources.thousands_separator

@Composable
fun RegistrationPreferencesScreen() {
    Scaffold(
        topBar = {
            BackButton {
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
            verticalArrangement = Arrangement.Bottom
        ) {
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

            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 240.dp, height = 100.dp)
            ) {
                Text(
                    text = "Elevated",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }

            Text(
                text = stringResource(Res.string.expenses_format)
            )

            Text(
                text = stringResource(Res.string.currency)
            )

            Text(
                text = stringResource(Res.string.decimal_separator)
            )

            Text(
                text = stringResource(Res.string.thousands_separator)
            )

            Button(
                onClick = {

                },
                content = {
                    Text(
                        text = stringResource(Res.string.start_tracking)
                    )
                }
            )
        }
    }
}