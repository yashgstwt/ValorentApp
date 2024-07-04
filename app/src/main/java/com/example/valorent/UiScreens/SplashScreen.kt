package com.example.valorent.UiScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.valorent.R
import com.example.valorent.ui.theme.valoBackground

@Preview(showBackground = true)
@Composable
fun SplashScreen(){
    Box(modifier = Modifier.fillMaxSize().background(valoBackground).wrapContentSize(Alignment.Center)){
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo" , modifier = Modifier.size(200.dp))

    }
}