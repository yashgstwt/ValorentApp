package com.example.valorent.DataLayer.AgentApi

import retrofit2.http.GET


interface ValorentApi  {
    @GET("agents")
    suspend fun getAgentsApi(): AgentList


}