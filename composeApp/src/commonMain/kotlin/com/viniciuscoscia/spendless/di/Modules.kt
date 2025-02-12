package com.viniciuscoscia.spendless.di

import com.plcoding.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
//    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
//    singleOf(::DefaultBookRepository).bind<BookRepository>()
//
//    single {
//        get<DatabaseFactory>().create()
//            .setDriver(BundledSQLiteDriver())
//            .build()
//    }
//    single { get<FavoriteBookDatabase>().favoriteBookDao }
//
//    viewModelOf(::BookListViewModel)
//    viewModelOf(::BookDetailViewModel)
//    viewModelOf(::SelectedBookViewModel)
}