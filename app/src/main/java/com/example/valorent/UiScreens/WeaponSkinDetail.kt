package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.lightBlack
import com.example.valorent.ui.theme.valoBackground

@Composable
fun WeaponSkinDetail (viewModal: ValorentViewModal ){
    Column(
        modifier = Modifier
            .padding()
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

        ) {
            Text(
                text = viewModal.selectedWeaponSkin?.displayName ?: "No Name",
                fontSize = 50.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(30.dp),
                fontFamily = ValorentFont
            )

            AsyncImage(
                model = viewModal.selectedWeaponSkin?.displayIcon,
                contentDescription = " ",
                contentScale = ContentScale.Inside,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = "Levels",
            fontSize = 50.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.padding(30.dp),
            fontFamily = ValorentFont
        )


        LazyRow(modifier = Modifier.height(300.dp)) {
            if (viewModal.selectedWeaponSkin?.levels != null){
                items(items = viewModal.selectedWeaponSkin?.levels!!){
                        level ->
                    Column(modifier = Modifier
                        .height(300.dp)
                        .width(250.dp)
                        .background(lightBlack).clip(RoundedCornerShape(15.dp)) ,
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        verticalArrangement = Arrangement.Center
                    ){
                        AsyncImage(model = level.displayIcon, contentDescription = "", modifier = Modifier
                            .height(200.dp)
                            .width(250.dp))
                        Text(text = level.displayName ?: "No Name", fontSize = 20.sp, fontFamily = ValorentFont, textAlign = TextAlign.Center, color = Color.White)

                    }
                }
            }
        }
    }
}