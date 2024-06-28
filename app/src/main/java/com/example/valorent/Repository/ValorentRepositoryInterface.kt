package com.example.valorent.Repository

import com.example.valorent.DataLayer.AgentApi.AgentList
import com.example.valorent.DataLayer.ValorentApi
import com.example.valorent.DataLayer.WeaponApi.WeaponList
import javax.inject.Inject

interface ValorentRepositoryInterface {
   suspend fun getAgentsData () :AgentList
   suspend fun getWeaponData(): WeaponList

}

class ValorentRepository @Inject constructor ( val ValorentApi : ValorentApi) : ValorentRepositoryInterface {
    override suspend fun getAgentsData(): AgentList = ValorentApi.getAgentsApi()
    override suspend fun getWeaponData(): WeaponList  = ValorentApi.getWeaponsApi()

}
