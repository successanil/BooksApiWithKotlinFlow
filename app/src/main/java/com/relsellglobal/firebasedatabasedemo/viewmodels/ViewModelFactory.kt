package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.relsellglobal.interfacesgateway.repository.IGRepository
import com.relsellglobal.repositorymodule.BooksApiRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val igRepsitory: BooksApiRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == CitiesViewModel::class.java) {
            return CitiesViewModel(igRepsitory) as T
        } else {
            throw IllegalStateException("Unknown Entity")
        }

    }
}