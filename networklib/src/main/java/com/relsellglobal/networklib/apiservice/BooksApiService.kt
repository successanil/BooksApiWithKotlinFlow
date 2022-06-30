package com.relsellglobal.networklib.apiservice

import com.relsellglobal.interfacesgateway.network.IGApiService
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService : IGApiService {
    @GET("booksVolumeListForBusiness")
    override suspend fun getBookListFromApi(@Query("q") query: String): BookListModel
}