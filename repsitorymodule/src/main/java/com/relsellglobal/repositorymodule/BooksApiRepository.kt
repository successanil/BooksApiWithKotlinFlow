package com.relsellglobal.repositorymodule

import com.relsellglobal.kotlinhiltdemo.repositories.network.VolumeInfo
import com.relsellglobal.networklib.apiservice.BooksApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BooksApiRepository @Inject constructor(
    private val booksApiService: BooksApiService
){
    fun getBooksListFromApi(queryString:String) = flow {
        val data = booksApiService.getBookListFromApi(queryString)
        val itemsList = data.items
        for(i in itemsList) {
            val list = ArrayList<VolumeInfo>()
            list.add(i)
            delay(1000L)
            emit(list)
        }
    }.flowOn(Dispatchers.IO)
}