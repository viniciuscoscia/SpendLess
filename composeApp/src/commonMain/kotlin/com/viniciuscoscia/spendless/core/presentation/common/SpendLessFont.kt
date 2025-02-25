package com.viniciuscoscia.spendless.core.presentation.common

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import spendless.composeapp.generated.resources.Figtree_Bold
import spendless.composeapp.generated.resources.Figtree_Light
import spendless.composeapp.generated.resources.Figtree_Medium

import spendless.composeapp.generated.resources.Figtree_Regular
import spendless.composeapp.generated.resources.Figtree_SemiBold
import spendless.composeapp.generated.resources.Res

@Composable
fun FigtreeFamily() = FontFamily(
    Font(Res.font.Figtree_Light, weight = FontWeight.Light),
    Font(Res.font.Figtree_Regular, weight = FontWeight.Normal),
    Font(Res.font.Figtree_Medium, weight = FontWeight.Medium),
    Font(Res.font.Figtree_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Figtree_Bold, weight = FontWeight.Bold)
)

@Composable
fun FigtreeTypography() = Typography().run {
    val fontFamily = FigtreeFamily()

    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}