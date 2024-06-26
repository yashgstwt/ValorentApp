package com.example.valorent.navigation

sealed class Screen ( val route : String ){
    object HOME : Screen("home_screen")
    object AgentDetail :Screen("agent_detail_screen")
    object MoreAgentDetails :Screen("moreAgentDetails")
    object WeaponDetail:Screen( "weapon_Detail")
    object SkinListScreen : Screen("skinList")
    object SkinDetail : Screen ("skinDetail")

}