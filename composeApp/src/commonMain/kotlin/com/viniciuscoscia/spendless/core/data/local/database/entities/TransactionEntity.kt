package com.viniciuscoscia.spendless.core.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val amount: Double,
    val receiver: String,
    val isExpense: Boolean,
    val date: Long,
    val categoryId: Int? = null,
    val note: String? = null,
    val repeatFrequency: String? = null
)