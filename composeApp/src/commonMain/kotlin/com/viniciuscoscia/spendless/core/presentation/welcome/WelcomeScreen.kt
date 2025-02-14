package com.viniciuscoscia.spendless.core.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.purple_wallet_icon
import spendless.composeapp.generated.resources.welcome_screen_title

@Composable
fun WelcomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(
                    vertical = 16.dp
                ),
                painter = painterResource(Res.drawable.purple_wallet_icon),
                contentDescription = "SVG Icon"
            )

            Text(
                fontSize = 28.sp,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                text = stringResource(Res.string.welcome_screen_title)
            )
        }
    }
}