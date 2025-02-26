package com.viniciuscoscia.spendless.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.viniciuscoscia.spendless.core.data.local.database.entities.CategoryEntity

@Dao
interface CategoryDao {
    @Insert
    suspend fun insert(category: CategoryEntity)

    @Insert
    suspend fun insertAll(categories: List<CategoryEntity>)

    @Query("SELECT * FROM CategoryEntity ORDER BY name ASC")
    suspend fun getAllCategories(): List<CategoryEntity>

    @Query("SELECT * FROM CategoryEntity WHERE id = :categoryId")
    suspend fun getCategoryById(categoryId: Int): CategoryEntity?
}
