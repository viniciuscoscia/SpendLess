package com.viniciuscoscia.spendless.core.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val username: String,
    val encryptedPin: String,
    val expensesFormat: String, // "BRACKETS" or "MINUS"
    val currency: String, // "USD", "EUR", etc.
    val decimalSeparator: String, // "." or ","
    val thousandsSeparator: String, // ".", ",", or " "
    val sessionDurationMinutes: Int = 5 * 60,
    val maxPinAttempts: Int = 3,
    val lockoutDurationSecs: Int = 30,
    val biometricsEnabled: Boolean = false
)