package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import coil.compose.AsyncImage
import com.example.valorent.DataLayer.AgentApi.Data
import com.example.valorent.ui.theme.lightBlack


@Composable
fun AgentCard( agentData : Data ){
    Box(modifier = Modifier
        .padding(10.dp)
        .height(200.dp)
        .fillMaxWidth()
        .background(Color.Transparent)
        .wrapContentSize(Alignment.BottomCenter)
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .clip(RoundedCornerShape(19.dp))
            .height(150.dp)
            .background(lightBlack),
         verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
     ){
            Text(text = agentData.displayName , fontSize = 35.sp , color = Color.White , modifier = Modifier.padding(start = 55.dp))
      }

     AsyncImage(model =agentData.fullPortraitV2 , contentDescription = "" , alignment = Alignment.BottomStart)

    }
}