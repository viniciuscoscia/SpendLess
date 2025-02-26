package com.viniciuscoscia.spendless.core.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val iconName: String
)