package com.viniciuscoscia.spendless

import androidx.compose.runtime.Composable
import com.viniciuscoscia.spendless.core.presentation.common.SpendLessTheme
import com.viniciuscoscia.spendless.core.presentation.registration.preferences.RegistrationPreferencesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    SpendLessTheme {
        RegistrationPreferencesScreen()
    }
}