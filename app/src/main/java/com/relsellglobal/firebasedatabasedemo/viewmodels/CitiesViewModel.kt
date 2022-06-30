package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.relsellglobal.firebasedatabasedemo.utils.ApiState
import com.relsellglobal.interfacesgateway.repository.IGRepository
import com.relsellglobal.repositorymodule.BooksApiRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class CitiesViewModel
    @Inject
    constructor(val booksApiRepository: BooksApiRepository): ViewModel() {
        var response: MutableStateFlow<ApiState> =  MutableStateFlow(ApiState.Empty)

        init {
            getBooksListFromApi("business")
        }

        fun getBooksListFromApi(queryString : String) = viewModelScope.launch {
            booksApiRepository.getBooksListFromApi(queryString)
                .onStart {
                    response.value = ApiState.Loading
                }.catch { it ->
                    response.value = ApiState.Failure(it)
                }.map {
                    it.items
                }.collect {

                    response.value  = ApiState.Success(it)
                }
        }

}