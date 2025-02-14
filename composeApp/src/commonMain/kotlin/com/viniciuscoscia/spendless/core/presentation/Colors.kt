package com.viniciuscoscia.spendless.core.presentation

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

// Primary Colors
val Primary = Color(0xFF5A00C8)
val OnPrimary = Color(0xFFFFFFFF)
val PrimaryContainer = Color(0xFF813BFF)
val OnPrimaryContainer = Color(0xFFFFFFFF)

// Primary Fixed Colors
val PrimaryFixed = Color(0xFFEAD0FF)
val OnPrimaryFixed = Color(0xFF24005A)
val OnPrimaryFixedVariant = Color(0xFF5900C7)
val InversePrimary = Color(0xFFD2BCFF)

// Secondary Colors
val Secondary = Color(0xFF5F6200)
val OnSecondary = Color(0xFFA14300)
val SecondaryContainer = Color(0xFFD2E750)
val OnSecondaryContainer = Color(0xFF414300)

// Secondary Fixed Colors
val SecondaryFixed = Color(0xFFE5EA58)
val SecondaryFixedDim = Color(0xFFC9CE3E)

// Tertiary Colors
val Tertiary = Color(0xFF006590)
val OnTertiary = Color(0xFFFFFFFF)
val TertiaryContainer = Color(0xFFC4E0F9)
val OnTertiaryContainer = Color(0xFF001E2E)

// Error Colors
val Error = Color(0xFFA40019)
val OnError = Color(0xFFFFFFFF)
val ErrorContainer = Color(0xFFFFDAD8)
val OnErrorContainer = Color(0xFF410007)

// Success Color
val Success = Color(0xFF23AC0B)

// Surface Colors
val Surface = Color(0xFFFCF9F9)
val OnSurface = Color(0xFF1B1B1C)
val OnSurfaceVariant = Color(0xFF44474B)
val SurfaceVariant = Color(0xFFE1E2EC)
val SurfaceBright = Color(0xFFFCF9F9)
val SurfaceDim = Color(0xFFDCD9D9)
val SurfaceTint = Primary

// Surface Container Colors - Now properly organized based on the new constructor
val SurfaceContainerLowest = Color(0xFFFFFFFF)
val SurfaceContainerLow = Color(0xFFF6F3F3)
val SurfaceContainer = Color(0xFFF0EDED)
val SurfaceContainerHigh = Color(0xFFEAE7E7)
val SurfaceContainerHighest = Color(0xFFE4E2E2)

// Background Colors
val Background = Color(0xFFFEF7FF)
val OnBackground = Color(0xFF1D1A25)

// Inverse Colors
val InverseSurface = Color(0xFF303031)
val InverseOnSurface = Color(0xFFF3F0F0)

// Outline Colors
val Outline = Color(0xFF75777B)
val OutlineVariant = Color(0xFFC5C6D0)

// Scrim Color
val Scrim = Color(0xFF000000)

// State Layer Opacities
object StateOpacity {
    // Primary state layers
    val Primary08 = Primary.copy(alpha = 0.08f)
    val Primary12 = Primary.copy(alpha = 0.12f)
    val Primary16 = Primary.copy(alpha = 0.16f)

    // Primary Container state layers
    val PrimaryContainer08 = PrimaryContainer.copy(alpha = 0.08f)
    val PrimaryContainer12 = PrimaryContainer.copy(alpha = 0.12f)

    // On Primary Container state layers
    val OnPrimaryContainer12 = OnPrimaryContainer.copy(alpha = 0.12f)

    // Secondary Container state layers
    val OnSecondaryContainer08 = OnSecondaryContainer.copy(alpha = 0.08f)
    val OnSecondaryContainer12 = OnSecondaryContainer.copy(alpha = 0.12f)

    // Error state layers
    val Error08 = Error.copy(alpha = 0.08f)
    val Error12 = Error.copy(alpha = 0.12f)

    // Background state layers
    val OnBackground08 = OnBackground.copy(alpha = 0.08f)
    val OnBackground12 = OnBackground.copy(alpha = 0.12f)

    // Surface state layers
    val OnSurface12 = OnSurface.copy(alpha = 0.12f)
    val OnSurfaceVariant12 = OnSurfaceVariant.copy(alpha = 0.12f)
}

val lightColorScheme: ColorScheme = ColorScheme(
    // Primary colors
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    onPrimaryContainer = OnPrimaryContainer,
    inversePrimary = InversePrimary,

    // Secondary colors
    secondary = Secondary,
    onSecondary = OnSecondary,
    secondaryContainer = SecondaryContainer,
    onSecondaryContainer = OnSecondaryContainer,

    // Tertiary colors
    tertiary = Tertiary,
    onTertiary = OnTertiary,
    tertiaryContainer = TertiaryContainer,
    onTertiaryContainer = OnTertiaryContainer,

    // Background and surface colors
    background = Background,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    surfaceTint = SurfaceTint,

    // Inverse colors
    inverseSurface = InverseSurface,
    inverseOnSurface = InverseOnSurface,

    // Error colors
    error = Error,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer,

    // Outline and scrim
    outline = Outline,
    outlineVariant = OutlineVariant,
    scrim = Scrim,

    // Surface brightness variations
    surfaceBright = SurfaceBright,
    surfaceDim = SurfaceDim,

    // Surface container hierarchy
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
    surfaceContainerLow = SurfaceContainerLow,
    surfaceContainerLowest = SurfaceContainerLowest
)