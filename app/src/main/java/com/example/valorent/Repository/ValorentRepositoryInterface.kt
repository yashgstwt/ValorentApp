package com.example.valorent.Repository

import com.example.valorent.DataLayer.AgentApi.AgentList
import com.example.valorent.DataLayer.AgentApi.ValorentApi
import javax.inject.Inject

interface ValorentRepositoryInterface {
   suspend fun getAgentsData () :AgentList

}

class ValorentRepository @Inject constructor ( val ValorentApi : ValorentApi ) : ValorentRepositoryInterface {
    override suspend fun getAgentsData(): AgentList = ValorentApi.getAgentsApi()

}
