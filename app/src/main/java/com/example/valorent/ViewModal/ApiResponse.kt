package com.example.valorent.ViewModal

import com.example.valorent.DataLayer.AgentApi.AgentList
import com.example.valorent.DataLayer.AgentApi.Data

sealed interface ApiResponse {
    data class Success(val agentList: AgentList) : ApiResponse
    data class Error(val error : Exception):ApiResponse
    object Loading : ApiResponse
}