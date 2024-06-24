package com.example.valorent.UiScreens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.valorent.ViewModal.ApiResponse
import com.example.valorent.ViewModal.ValorentViewModal

@Composable
fun AgentListScreen ( viewModal: ValorentViewModal ){

    var apiState = viewModal.apiResponseState


    when(apiState){
        is ApiResponse.Success ->  {
            LazyColumn(){
                items( apiState.agentList.data){
                        agentCard ->

                }
            }
        }

        is ApiResponse.Error -> TODO()
        ApiResponse.Loading -> TODO()
    }



}


