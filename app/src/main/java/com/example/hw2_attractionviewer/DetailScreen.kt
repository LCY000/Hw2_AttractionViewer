package com.example.hw2_attractionviewer

// b11109005
// 2024.5.21完成

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hw2_attractionviewer.ui.theme.ViewerViewModel
import com.example.hw2_attractionviewer.data.places

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(
    modifier: Modifier = Modifier,
    @StringRes placeName : Int,
    onBackClick: () -> Unit

) {
    CenterAlignedTopAppBar(
        title = {
            Text( stringResource(placeName) )
        },
        navigationIcon = {
             IconButton(onClick = onBackClick) {
                 Icon(
                     painter = painterResource(id = R.drawable.ic_arrow_back),
                     contentDescription = "Return to previous page button"
                 )
             }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )
}


@Composable
fun DetailScreen(
    viewModel: ViewerViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    val place = remember { places[viewModel.getDataNumber()] }

    Scaffold (
        topBar = {
            DetailAppBar(
                placeName = place.name,
                onBackClick = {navController.navigateUp()}
            )
        }
    ){ paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            //照片
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(4f)
                    .offset(y = 15.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(place.imageResourceId),
                    contentDescription = "null",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .border(15.dp, Color.White)
                        .shadow(8.dp)
                        .padding(15.dp)
                        .width(330.dp)
                )
            }

            //詳細介紹文字
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(6f),
                contentAlignment = Alignment.Center
            ){
                DetailText( text = place.introduction )
            }

            //地圖按鈕
            val placeName = stringResource(place.name)
            val context = LocalContext.current
            val lat: Double = place.latitude
            val lon: Double = place.longitude
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
                    .offset(y = (-10).dp),
                contentAlignment = Alignment.Center
            ){
                Button(
                    onClick = {
                        val gmmIntentUri = Uri.parse("geo:$lat,$lon?q=$lat,$lon($placeName)")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        context.startActivity(mapIntent)

                    }
                ) {
                Text(text = "前往地圖")
                }
            }
        }

    }
}

@Composable
fun DetailText(
    @StringRes text: Int
){
    Box(
        modifier = Modifier
            .padding(40.dp)
            .shadow(4.dp, shape = RoundedCornerShape(20.dp))
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(20.dp)
            )

    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = text),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(18.dp),
                fontSize = 16.sp
            )
        }
    }
}