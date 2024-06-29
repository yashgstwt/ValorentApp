package com.example.valorent.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorent.R
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.navigation.Screen
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.lightBlack
import com.example.valorent.ui.theme.valoBackground


@Composable
fun WeaponDetail(viewModal: ValorentViewModal , navController: NavController) {
    val infoFontSize = 20.sp
    val headingFontSize = 30.sp

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate(Screen.SkinListScreen.route) },modifier= Modifier.size(80.dp) , containerColor = darkRed) {
            Icon(painter = painterResource(id =R.drawable.gun ), contentDescription = "")
        }
    }) {padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(valoBackground)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 200.dp,))
                    .height(320.dp)
                    .background(darkRed)
                // .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = viewModal.selectedWeapon?.displayName ?: "No Name",
                    fontSize = 50.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(30.dp),
                    fontFamily = ValorentFont
                )

                AsyncImage(
                    model = viewModal.selectedWeapon?.displayIcon,
                    contentDescription = " ",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = viewModal.selectedWeapon?.displayName ?: "No Name",
                fontSize = 40.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(10.dp),
                fontFamily = ValorentFont
            )
            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = "Weapon Stats",
                fontSize = headingFontSize,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(10.dp),
                fontFamily = ValorentFont
            )
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(lightBlack)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Text(
                    text = "Fire Rate :${viewModal.selectedWeapon?.weaponStats?.fireRate} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Magazine Size :${viewModal.selectedWeapon?.weaponStats?.magazineSize} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "RunSpeedMultiplier :${viewModal.selectedWeapon?.weaponStats?.runSpeedMultiplier} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "EquipTimeSeconds :${viewModal.selectedWeapon?.weaponStats?.equipTimeSeconds} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "ReloadTimeSeconds :${viewModal.selectedWeapon?.weaponStats?.reloadTimeSeconds} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "FirstBulletAccuracy :${viewModal.selectedWeapon?.weaponStats?.firstBulletAccuracy} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "ZoomMultiplier :${viewModal.selectedWeapon?.weaponStats?.adsStats?.zoomMultiplier} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(
                text = "DamageRanges",
                fontSize = headingFontSize,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(10.dp),
                fontFamily = ValorentFont
            )
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(lightBlack)
                    .clip(RoundedCornerShape(15.dp))

            ) {
                Text(
                    text = "RangeStartMeters :${viewModal.selectedWeapon?.weaponStats?.damageRanges?.get(0)?.rangeStartMeters} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "RangeEndMeters :${viewModal.selectedWeapon?.weaponStats?.damageRanges?.get(0)?.rangeEndMeters} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "HeadDamage :${viewModal.selectedWeapon?.weaponStats?.damageRanges?.get(0)?.headDamage} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "BodyDamage :${
                        viewModal.selectedWeapon?.weaponStats?.damageRanges?.get(0)?.bodyDamage} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "LegDamage :${viewModal.selectedWeapon?.weaponStats?.damageRanges?.get(0)?.legDamage} ",
                    fontSize = infoFontSize,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}