package com.example.valorent.UiScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.valorent.R
import com.example.valorent.ui.theme.valoBackground

@Composable
fun Loading () {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading))
    Box(modifier = Modifier.fillMaxSize().background(valoBackground), contentAlignment = Alignment.Center ){

        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever, modifier = Modifier.size(100.dp))

    }
}