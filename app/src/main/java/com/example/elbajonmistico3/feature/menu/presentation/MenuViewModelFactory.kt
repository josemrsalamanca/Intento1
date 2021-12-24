package com.example.elbajonmistico3.feature.menu.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MenuViewModelFactory(private val repository: MenuRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel>create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(MenuViewModel::class.java)){
            return MenuViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }
}