package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.firebasedatabasedemo.utils.AppConstants
import com.relsellglobal.interfacesgateway.network.IGApiService
import com.relsellglobal.networklib.apiservice.BooksApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.Http.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesBooksApiService(retrofit: Retrofit) : BooksApiService {
        return retrofit.create(BooksApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesIGApiServiceForBookService(booksApiService: BooksApiService) : IGApiService {
        return booksApiService
    }

}