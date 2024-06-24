package com.example.valorent.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valorent.R
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.valoBackground
import java.util.Locale

@Preview( showSystemUi = true)
@Composable
fun AgentDetailScreen(){

    Column (modifier = Modifier
        .fillMaxSize()
        .background(valoBackground)
        .verticalScroll(rememberScrollState())
    ) {
        ImagePart()
        Text(text = "yoru" , fontSize = 35.sp , fontWeight = FontWeight.Bold , color = Color.White , modifier = Modifier.padding(start = 20.dp))


    }

}

@Composable
fun ImagePart(){
    Box(){
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 200.dp,))
            .height(320.dp)
            .background(darkRed)
            .wrapContentSize(Alignment.CenterEnd)
        ){

        Text(text = "brim".toUpperCase(Locale.ROOT),
            modifier = Modifier
                .graphicsLayer { rotationZ = 90f; translationX = 90f; }
                .align(AbsoluteAlignment.CenterLeft)
                .alpha(0.5f) ,
            fontSize = 50.sp ,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        }

        Image(painter = painterResource(id = R.drawable._citypng_com_hd_valorant_game_yoru_agent_character_player_png___2000x2000), contentDescription =" " , alignment = Alignment.BottomCenter )

    }
}