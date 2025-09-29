package com.example.valorent.UiScreens



import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.valorent.ViewModal.ValorentViewModal
import com.example.valorent.ui.theme.ValorentFont
import com.example.valorent.ui.theme.darkRed
import com.example.valorent.ui.theme.lightBlack
import com.example.valorent.ui.theme.valoBackground
import java.util.Locale

@Composable
fun AgentDetailScreen(viewModal: ValorentViewModal){
val data = viewModal.selectedAgent
    Column (modifier = Modifier
        .fillMaxSize()
        .background(valoBackground)
        .verticalScroll(rememberScrollState())
    ) {
        if (data?.fullPortraitV2 != null) {
            ImagePart(data.fullPortraitV2, data.displayName)
        }
            Text(text = data?.displayName.toString() ,
                fontSize = 35.sp ,
                fontWeight = FontWeight.Bold , color = Color.White ,
                modifier = Modifier.padding(start = 20.dp),
                fontFamily = ValorentFont

            )

            Text(text = data?.description.toString(),
                fontSize = 20.sp ,
                color = Color.White ,
                modifier = Modifier.padding(start = 10.dp , top = 20.dp , end = 10.dp),
                fontStyle = FontStyle.Italic
            )
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Abilities" ,
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold ,
            color = Color.White ,
            modifier = Modifier.padding(start = 10.dp),
            fontFamily = ValorentFont
        )

        LazyRow(modifier = Modifier
            .height(150.dp)
            .padding(start = 10.dp)
        ,
        ) {
            items(data?.abilities!!){
                abilities ->
                //viewModal.selectedAbility= data.abilities[0].description
                Column(modifier= Modifier.padding(end = 5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { viewModal.selectedAbility = abilities.description }
                ) {
                    AbilityCard(abilities.displayName ,abilities.displayIcon)
                }
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = viewModal.selectedAbility.toString().let{
            if (it.isEmpty()){
                "Please select any ability to show description"
            }else{
                viewModal.selectedAbility!!
            }
        },
            fontSize = 20.sp ,
            fontStyle = FontStyle.Italic ,
            color = Color.White ,
            modifier = Modifier.padding( 20.dp)
        )
    }
}

@Composable
fun AbilityCard(name: String , image : String ){
    Column(modifier = Modifier.background(lightBlack)
        .padding(5.dp)
    ){
        AsyncImage(model = image,
            contentDescription ="",
            modifier = Modifier.size(100.dp).padding(5.dp).align(Alignment.CenterHorizontally) ,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
        )

        Text(text = name , fontSize = 20.sp , color = Color.White, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ImagePart(imgURL:String , name :String){
    var isDisplayed by remember {
        mutableStateOf(false)
    }
    val transitionX by animateFloatAsState(targetValue =  if (isDisplayed) 0f else -800f , animationSpec = tween(durationMillis = 500) )
    Box(){
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 200.dp,))
            .height(320.dp)
            .background(darkRed)
            .wrapContentSize(Alignment.CenterEnd)
        ){

        Text(text = name .toUpperCase(Locale.ROOT),
            modifier = Modifier
                .graphicsLayer { rotationZ = 90f; translationX = 90f; }
                .align(AbsoluteAlignment.CenterLeft)
                .alpha(0.5f) ,
            fontSize = 50.sp ,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = ValorentFont
        )

        }
        AsyncImage(model = imgURL , contentDescription =" " , alignment = Alignment.BottomCenter, onSuccess = {  isDisplayed = true  },  modifier =Modifier.graphicsLayer(translationX = transitionX) )
    }
}