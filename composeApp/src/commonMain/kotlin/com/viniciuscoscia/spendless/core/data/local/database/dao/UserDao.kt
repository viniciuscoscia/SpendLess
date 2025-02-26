package com.viniciuscoscia.spendless.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.viniciuscoscia.spendless.core.data.local.database.entities.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: UserEntity)

    @Update
    suspend fun update(user: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    suspend fun getUserByUsername(username: String): UserEntity?

    @Query("SELECT COUNT(*) FROM UserEntity WHERE username = :username")
    suspend fun usernameExists(username: String): Int

    @Query("SELECT * FROM UserEntity LIMIT 1")
    suspend fun getCurrentUser(): UserEntity?
}