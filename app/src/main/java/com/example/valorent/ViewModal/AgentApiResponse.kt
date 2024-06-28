package com.example.valorent.ViewModal

import com.example.valorent.DataLayer.AgentApi.AgentList
import com.example.valorent.DataLayer.WeaponApi.WeaponList

sealed interface AgentApiResponse {
    data class Success(val agentList: AgentList) : AgentApiResponse
    data class Error(val error : Exception):AgentApiResponse
    data object Loading : AgentApiResponse
}
sealed interface WeaponApiResponse {
    data class Success(val weaponList: WeaponList) :WeaponApiResponse
    data class Error(val error : Exception):WeaponApiResponse
    data object Loading : WeaponApiResponse
}