package com.relsellglobal.interfacesgateway.network

import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork

interface IGApiService {
    suspend fun getBookListFromApi(query: String): BookListModel
}