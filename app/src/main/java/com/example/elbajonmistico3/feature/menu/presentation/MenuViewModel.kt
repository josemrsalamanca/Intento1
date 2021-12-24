package com.example.elbajonmistico3.feature.menu.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elbajonmistico3.feature.menu.data.remote.MenuResponse
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import retrofit2.Response

class MenuViewModel(private val menuRepository: MenuRepository): ViewModel() {

    private val mutableState = MutableLiveData<MenuResponse>()
    fun state() : LiveData<MenuResponse> = mutableState
    fun getMenu() {
        viewModelScope.launch {
            val menu = menuRepository.getMenu()
            handleState(menu)
        }
    }

    private fun handleState(menu: Response<MenuResponse>) {
        if(menu.isSuccessful){
            handleBody(menu.body())
        }else{
            TODO()
        }
    }

    private fun handleBody(body: MenuResponse?) {
        body?.let { safebody->
            mutableState.postValue(safebody)
        }
    }
}