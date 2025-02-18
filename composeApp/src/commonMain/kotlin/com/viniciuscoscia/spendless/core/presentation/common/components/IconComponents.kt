package com.viniciuscoscia.spendless.core.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import spendless.composeapp.generated.resources.Res
import spendless.composeapp.generated.resources.purple_wallet_icon

@Composable
fun WalletIcon() {
    Image(
        modifier = Modifier.padding(
            vertical = 24.dp
        ),
        painter = painterResource(Res.drawable.purple_wallet_icon),
        contentDescription = ""
    )
}