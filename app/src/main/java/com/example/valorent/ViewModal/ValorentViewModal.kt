package com.example.valorent.ViewModal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorent.DataLayer.AgentApi.Data
import com.example.valorent.DataLayer.WeaponApi.Skin
import com.example.valorent.DataLayer.WeaponApi.WeaponData
import com.example.valorent.Repository.ValorentRepository
import com.example.valorent.ViewModal.AgentApiResponse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ValorentViewModal  @Inject constructor (private val repository: ValorentRepository ) : ViewModel() {
    var agentApiResponseState: AgentApiResponse by mutableStateOf(Loading)
        private set

    var weaponApiResponseState: WeaponApiResponse by mutableStateOf(WeaponApiResponse.Loading)
        private set

    var selectedAgent: Data? by mutableStateOf(null)

    var selectedWeapon : WeaponData? by mutableStateOf(null)

    var selectedAbility:String? by mutableStateOf("Please select the Ability to get description")

    var selectedWeaponSkin : Skin? by mutableStateOf(null)
    //state for list in home screen i.e agent / Weapon
    var currentList :Int by mutableIntStateOf(0)

init {
    getAgents()
}
    fun getAgents(){
        viewModelScope.launch {
            agentApiResponseState =  try {
                Success(repository.getAgentsData())
            }catch (e :Exception) {
                Error(e)
            }catch (e: HttpException){
                Error(e)
            }
        }
    }
    fun getWeapon(){
        viewModelScope.launch {
            weaponApiResponseState= try{
              WeaponApiResponse.Success( repository.getWeaponData())
            }catch (e:Exception){
                WeaponApiResponse.Error(e)
            }
        }
    }
}