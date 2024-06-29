package com.example.valorent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorent.UiScreens.AgentDetailScreen
import com.example.valorent.UiScreens.AgentListScreen
import com.example.valorent.UiScreens.SkinListScreen
import com.example.valorent.UiScreens.WeaponDetail
import com.example.valorent.UiScreens.WeaponSkinCard
import com.example.valorent.UiScreens.WeaponSkinDetail
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.navigation.Screen
import com.example.valorent.ui.theme.ValorentTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ValorentTheme {
                val viewModel : ValorentViewModal by  viewModels()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.HOME.route ) {
                    composable(route = Screen.HOME.route) {
                        AgentListScreen ( viewModel,navController )
                    }
                    composable(route = Screen.AgentDetail.route){
                        AgentDetailScreen(viewModal = viewModel)
                    }
                    composable(route = Screen.SkinListScreen.route){
                        SkinListScreen(viewModel,navController)
                    }
                    composable(route = Screen.WeaponDetail.route){
                        WeaponDetail(viewModel,navController)
                    }
//                    composable(Screen.SkinDetail.route){
//                        WeaponSkinDetail(viewModel)
//                    }
                }
            }
        }
    }
}


