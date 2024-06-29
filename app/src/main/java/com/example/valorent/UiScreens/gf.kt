package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valorent.ui.theme.valoBackground

@Preview(showSystemUi = true)
@Composable
fun n(){
  Box(modifier = Modifier
    .size(65.dp)
    .background(valoBackground)){

    Text(text = "hello world " , fontSize = 102.sp , color = Color.White , overflow = TextOverflow.Clip, maxLines = 1 )
  }
}