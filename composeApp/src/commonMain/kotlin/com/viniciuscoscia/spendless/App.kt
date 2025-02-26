package com.viniciuscoscia.spendless

import androidx.compose.runtime.Composable
import com.viniciuscoscia.spendless.core.presentation.common.SpendLessTheme
import com.viniciuscoscia.spendless.features.auth.presentation.registration.username.RegisterUsernameScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    SpendLessTheme {
        RegisterUsernameScreen()
    }
}