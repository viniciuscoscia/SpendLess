package com.viniciuscoscia.spendless.core.presentation.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.viniciuscoscia.spendless.core.presentation.common.components.SubtitleText
import com.viniciuscoscia.spendless.core.presentation.common.components.TitleText
import com.viniciuscoscia.spendless.core.presentation.common.components.WalletIcon
import org.jetbrains.compose.resources.stringResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.already_have_an_account
import spendless.composeapp.generated.resources.next
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

            TitleText(
                text = stringResource(Res.string.welcome_screen_title)
            )

            SubtitleText(
                text = stringResource(Res.string.welcome_screen_subtitle)
            )

            UserNameTextField()

            NextButton()

            AlreadyHaveAccountButton()
        }
    }
}


@Composable
private fun UserNameTextField() {
    var basicText by remember { mutableStateOf("") }
    val fontSize = 32.sp
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    BasicTextField(
        value = basicText,
        onValueChange = {
            basicText = it
        },
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .height(62.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.onBackground.copy(0.08f))
            .focusRequester(focusRequester)
            .onFocusChanged {
                isFocused = it.isFocused
            },
        textStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { focusRequester.requestFocus() },
                contentAlignment = Alignment.Center
            ) {
                if (basicText.isEmpty() && !isFocused) {
                    Text(
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        text = stringResource(Res.string.username),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                        fontSize = fontSize
                    )
                }
                innerTextField()
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
                text = stringResource(Res.string.already_have_an_account)
            )
        }
    )
}
