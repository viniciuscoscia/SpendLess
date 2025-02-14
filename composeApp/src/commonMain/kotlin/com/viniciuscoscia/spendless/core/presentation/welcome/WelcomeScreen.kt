package com.viniciuscoscia.spendless.core.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.next
import spendless.composeapp.generated.resources.purple_wallet_icon
import spendless.composeapp.generated.resources.username
import spendless.composeapp.generated.resources.welcome_screen_subtitle
import spendless.composeapp.generated.resources.welcome_screen_title

@Composable
fun WelcomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WalletIcon()

            TitleText()

            SubtitleText()

            UserNameTextField()

            NextButton()

            AlreadyHaveAccountButton()
        }
    }
}

@Composable
private fun WalletIcon() {
    Image(
        modifier = Modifier.padding(
            vertical = 24.dp
        ),
        painter = painterResource(Res.drawable.purple_wallet_icon),
        contentDescription = ""
    )
}


@Composable
private fun TitleText() {
    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        fontSize = 28.sp,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurface,
        text = stringResource(Res.string.welcome_screen_title)
    )
}

@Composable
private fun SubtitleText() {
    Text(
        text = stringResource(Res.string.welcome_screen_subtitle),
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 14.sp,
    )
}

@Composable
private fun UserNameTextField() {
    var basicText by remember { mutableStateOf("") }

    BasicTextField(
        value = basicText,
        onValueChange = {
            basicText = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .height(62.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.onBackground.copy(0.08f)),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (basicText.isEmpty()) {
                    Text(
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        text = stringResource(Res.string.username),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                        fontSize = 36.sp
                    )
                } else {
                    innerTextField()
                }
            }
        }
    )
}

@Composable
private fun NextButton() {
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .height(56.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(16.dp)
            ),
        content = {
            Text(
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                text = stringResource(Res.string.next)
            )
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    )
}

@Composable
private fun AlreadyHaveAccountButton() {
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .height(56.dp),
        content = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                text = "Already have an account?"
            )
        }
    )
}
