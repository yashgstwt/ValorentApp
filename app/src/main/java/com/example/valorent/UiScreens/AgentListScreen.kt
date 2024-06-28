package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.valorent.ViewModal.AgentApiResponse
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.ViewModal.WeaponApiResponse
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.valoBackground

@Composable
fun AgentListScreen ( viewModal: ValorentViewModal, navController: NavController ){

    val agentApiState = viewModal.agentApiResponseState
    val weaponApiState = viewModal.weaponApiResponseState

    Scaffold (
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar(viewModal) }
    ){ paddingValues ->

        when(viewModal.currentList){
            0 -> {
                when(agentApiState){
                    is AgentApiResponse.Success ->  {
                        LazyColumn(modifier = Modifier.padding(paddingValues) .background(valoBackground)){
                            items( agentApiState.agentList.data){
                                    agentCard ->
                                AgentCard(agentData = agentCard, navController , viewModal)
                            }
                        }
                    }
                    is AgentApiResponse.Error -> {
                        Text(text = agentApiState.error.toString(), fontSize = 25.sp , textAlign = TextAlign.Center )
                    }
                    AgentApiResponse.Loading ->{
                        Text(text = "Loading", fontSize = 30.sp , textAlign = TextAlign.Center)
                    }
                }
            }
            1 -> {
                when(weaponApiState){
                    is WeaponApiResponse.Success ->  {
                        LazyColumn(modifier = Modifier.padding(paddingValues)){
                           items(weaponApiState.weaponList.data){
                                   WeaponCard ->
                               WeaponCard(WeaponCard , navController)
                            }
                        }
                    }
                    is WeaponApiResponse.Error -> {
                        Text(text = weaponApiState.error.toString(),
                            fontSize = 25.sp ,
                            textAlign = TextAlign.Center
                        )
                    }

                    is WeaponApiResponse.Loading -> {
                        Text(text =  "Loading pls wait",
                            fontSize = 25.sp ,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopAppBar(){
    Box(modifier = Modifier
        .padding(WindowInsets.statusBars.asPaddingValues())
        .fillMaxWidth()
        .height(50.dp)
        .background(darkRed)
        .wrapContentSize(align = Alignment.Center)
    ){
        Text(text = "VALORENT", fontSize = 35.sp, textAlign = TextAlign.Center, fontFamily = ValorentFont)
    }
}

@Composable
fun BottomAppBar(viewModal: ValorentViewModal) {
    Row(modifier = Modifier
        .padding(WindowInsets.navigationBars.asPaddingValues())
        .fillMaxWidth()
        .height(50.dp)
        .background(darkRed),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly

    ){
        Text(text = "AGENTS",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = ValorentFont ,
            modifier= Modifier.clickable { viewModal.currentList = 0  }
        )
        Text(text = "WEAPONS",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = ValorentFont,
            modifier= Modifier.clickable { viewModal.currentList = 1
            viewModal.getWeapon()
            }
        )
    }
}