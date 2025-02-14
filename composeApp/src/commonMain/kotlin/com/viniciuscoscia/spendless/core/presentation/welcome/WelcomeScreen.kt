package com.viniciuscoscia.spendless.core.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.purple_wallet_icon
import spendless.composeapp.generated.resources.welcome_screen_subtitle
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

            Text(
                modifier = Modifier.padding(
                    horizontal = 16.dp
                ),
                text = stringResource(Res.string.welcome_screen_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
            )

            var basicText by remember { mutableStateOf("") }

            val backgroundColor = Color(0xFFF5F5F5) // Light gray background
            val textColor = Color.DarkGray
            val placeholderColor = Color.Gray

            BasicTextField(
                value = basicText,
                onValueChange = {
                    basicText = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(backgroundColor),
                textStyle = TextStyle(
                    color = textColor,
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
                                modifier = Modifier.fillMaxSize(),
                                textAlign = TextAlign.Center,
                                text = "username",
                                color = placeholderColor,
                                fontSize = 16.sp
                            )
                        } else {
                            innerTextField()
                        }
                    }
                }
            )

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
                    .height(56.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(12.dp)
                    ),
                content = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        text = "Next ->"
                    )
                }
            )

            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 16.dp)
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
    }
}