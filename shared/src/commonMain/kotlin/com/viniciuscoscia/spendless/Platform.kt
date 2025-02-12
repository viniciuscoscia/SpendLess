package com.viniciuscoscia.spendless

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform