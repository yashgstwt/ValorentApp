package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorent.DataLayer.WeaponApi.WeaponData
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.navigation.Screen
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.lightBlack
import com.example.valorent.ui.theme.valoBackground

@Composable
fun WeaponCard(Weapon : WeaponData, navController: NavController,viewModal: ValorentViewModal){

      Column(modifier = Modifier
          .padding(10.dp)
          .height(150.dp)
          .fillMaxWidth()
          .clip(RoundedCornerShape(19.dp))
          .background(lightBlack)
          .clickable {
              navController.navigate(Screen.WeaponDetail.route)
              viewModal.selectedWeapon = Weapon
          },
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center

      ){
          AsyncImage(model = Weapon.displayIcon  , contentDescription = "" , alignment = Alignment.BottomStart, modifier = Modifier.height(100.dp) )
          Spacer(modifier =Modifier.height(10.dp) )
          Text(text =Weapon.displayName  , fontSize = 35.sp , color = Color.White , modifier = Modifier.padding(start = 55.dp), fontFamily = ValorentFont)

   }
}