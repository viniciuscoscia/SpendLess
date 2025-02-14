package com.viniciuscoscia.spendless.core.presentation.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String) {
    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        fontSize = 28.sp,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurface,
        text = text
    )
}

@Composable
fun SubtitleText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 14.sp,
    )
}