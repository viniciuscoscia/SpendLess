package com.viniciuscoscia.spendless.core.security.encryption

expect class EncryptionManager {
    fun encrypt(data: String, key: String): String
    fun decrypt(encryptedData: String, key: String): String
}