package com.example.valorent.DataLayer

import com.example.valorent.DataLayer.AgentApi.AgentList
import com.example.valorent.DataLayer.WeaponApi.WeaponList
import retrofit2.http.GET


interface ValorentApi  {
    @GET("agents")
    suspend fun getAgentsApi(): AgentList
    @GET("weapons")
    suspend fun getWeaponsApi():WeaponList
}