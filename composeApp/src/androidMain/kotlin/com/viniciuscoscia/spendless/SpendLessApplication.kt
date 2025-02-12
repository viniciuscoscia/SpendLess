package com.viniciuscoscia.spendless

import android.app.Application
import com.viniciuscoscia.spendless.di.initKoin
import org.koin.android.ext.koin.androidContext

class SpendLessApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@SpendLessApplication)
        }
    }
}