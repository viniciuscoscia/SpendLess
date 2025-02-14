package com.viniciuscoscia.spendless.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SpendLessTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = FigtreeTypography(),
        content = content
    )
}