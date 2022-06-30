package com.relsellglobal.firebasedatabasedemo.utils

import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import com.relsellglobal.kotlinhiltdemo.repositories.network.VolumeInfo

sealed class ApiState {
    class Success(val data:List<VolumeInfo>) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}