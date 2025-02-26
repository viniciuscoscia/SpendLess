package com.viniciuscoscia.spendless.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.viniciuscoscia.spendless.core.data.local.database.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insert(transaction: TransactionEntity): Long

    @Update
    suspend fun update(transaction: TransactionEntity)

    @Delete
    suspend fun delete(transaction: TransactionEntity)

    @Query("SELECT * FROM TransactionEntity ORDER BY date DESC")
    fun getAllTransactionsAsFlow(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM TransactionEntity ORDER BY date DESC LIMIT :limit")
    suspend fun getRecentTransactions(limit: Int): List<TransactionEntity>

    @Query("SELECT * FROM TransactionEntity WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    suspend fun getTransactionsBetweenDates(startDate: Long, endDate: Long): List<TransactionEntity>

    @Query("SELECT SUM(amount) FROM TransactionEntity WHERE isExpense = 1 AND categoryId = :categoryId")
    suspend fun getTotalSpentByCategory(categoryId: Int): Double?

    @Query("SELECT categoryId, SUM(amount) as total FROM TransactionEntity WHERE isExpense = 1 GROUP BY categoryId ORDER BY total DESC LIMIT 1")
    suspend fun getMostSpentCategoryId(): CategoryWithAmount?

    @Query("SELECT * FROM TransactionEntity WHERE isExpense = 1 ORDER BY amount DESC LIMIT 1")
    suspend fun getLargestExpenseTransaction(): TransactionEntity?

    @Query("SELECT SUM(amount) FROM TransactionEntity WHERE isExpense = 1 AND date BETWEEN :startOfWeek AND :endOfWeek")
    suspend fun getTotalSpentInWeek(startOfWeek: Long, endOfWeek: Long): Double?

    @Query(
        "SELECT SUM(CASE WHEN isExpense = 1 THEN amount ELSE 0 END) as expenses, " +
                "SUM(CASE WHEN isExpense = 0 THEN amount ELSE 0 END) as income " +
                "FROM TransactionEntity"
    )
    suspend fun getAccountSummary(): AccountSummary?
}

data class CategoryWithAmount(
    val categoryId: Int,
    val total: Double
)

data class AccountSummary(
    val expenses: Double,
    val income: Double
) {
    val balance: Double get() = income - expenses
}