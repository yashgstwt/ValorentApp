package com.example.valorent.ViewModal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorent.DataLayer.AgentApi.Ability
import com.example.valorent.DataLayer.AgentApi.Data
import com.example.valorent.Repository.ValorentRepository
import com.example.valorent.ViewModal.ApiResponse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ValorentViewModal  @Inject constructor (private val repository: ValorentRepository ) : ViewModel() {
    var apiResponseState: ApiResponse by mutableStateOf(Loading)
    private set

    var selectedAgent: Data? by mutableStateOf(null)

    var selectedAbility:String? by mutableStateOf(selectedAgent?.abilities?.get(0)?.description)
init {
    getAgents()
}
    fun getAgents(){
        viewModelScope.launch {
            apiResponseState =  try {
                Success(repository.getAgentsData())
            }catch (e :Exception) {
                Error(e)
            }catch (e: HttpException){
                Error(e)
            }
        }
    }
}