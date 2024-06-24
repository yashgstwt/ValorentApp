package com.example.valorent.UiScreens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
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
                        AgentCard(agentData = agentCard)
                }
            }
        }

        is ApiResponse.Error -> {
            Text(text = apiState.error.toString(), fontSize = 25.sp , textAlign = TextAlign.Center )
        }
        ApiResponse.Loading ->{
            Text(text = "Loading", fontSize = 30.sp , textAlign = TextAlign.Center)
        }
    }



}


