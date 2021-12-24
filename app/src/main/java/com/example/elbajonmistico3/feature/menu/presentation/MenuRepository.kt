package com.example.elbajonmistico3.feature.menu.presentation

import com.example.elbajonmistico3.feature.menu.data.remote.MenuApi

class MenuRepository(private val menuApi: MenuApi) {
    suspend fun getMenu() = menuApi.obtenerMenu()
}
