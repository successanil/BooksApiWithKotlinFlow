package com.relsellglobal.interfacesgateway.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.relsellglobal.localdblib.entities.CitiesForUser
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork

interface IGRepository {
    fun getBooksListFromApi(queryString:String)
}