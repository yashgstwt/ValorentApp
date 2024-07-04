package com.example.valorent.UiScreens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorent.R
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.valoBackground
import java.util.Locale

@Preview(showSystemUi = true)
@Composable
fun n(){
  var isDisplayed by remember {
    mutableStateOf(false)
  }
  val transitionY by animateFloatAsState(targetValue = if (isDisplayed) 350f else 300f  , animationSpec = infiniteRepeatable(
    animation = tween(durationMillis = 4000),
    repeatMode = RepeatMode.Reverse)
  )
  val colors = arrayOf(Color.Black, Color.Transparent)
  val gradint = Brush.linearGradient(   0f to Color.Transparent, 90f to Color.Black )
  Box {
    Box(modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(bottomStart = 200.dp,))
      .height(320.dp)
      .background(darkRed)
      .wrapContentSize(Alignment.CenterEnd)
    ){

      Text(text = "Yoru",
        modifier = Modifier
          .graphicsLayer { rotationZ = 90f; translationX = 70f; }
          .align(AbsoluteAlignment.CenterLeft)
          .alpha(0.5f) ,
        fontSize = 50.sp ,
        textAlign = TextAlign.End,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontFamily = ValorentFont
      )
    }

    AsyncImage(model = "https://media.valorant-api.com/weapons/63e6c2b6-4a8e-869c-3d4c-e38355226584/displayicon.png" ,
      contentDescription = "" , alignment = Alignment.BottomStart ,
      onSuccess = {  isDisplayed = true  },
      modifier =Modifier.graphicsLayer(translationY = transitionY, translationX = 80f)
    )
    Box(modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(bottomStart = 200.dp,))
      .height(320.dp)
      .background(gradint))

  }
}


