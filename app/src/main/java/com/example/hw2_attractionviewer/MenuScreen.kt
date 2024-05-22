package com.example.hw2_attractionviewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hw2_attractionviewer.data.Place
import com.example.hw2_attractionviewer.data.places
import com.example.hw2_attractionviewer.ui.theme.ViewerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuAppBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )
}


@Composable
fun MenuScreen(
    viewModel: ViewerViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { MenuAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues){
            itemsIndexed(places){ index, place->
                PlaceCard(
                    modifier = modifier,
                    place = place,
                    onClick = {
                        viewModel.setDataNumber(index)
                        navController.navigate("detailPage")
                        },
                )
            }
        }



    }
}


@Composable
fun PlaceCard(
    modifier: Modifier = Modifier,
    place: Place,
    onClick: () -> Unit = {},
){
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier= Modifier
            .padding(8.dp)  //每個卡片的間隔

    ){
        Row(
            modifier = Modifier
                .clickable(
                    onClick = { onClick() },
                )
                .fillMaxWidth()
                .padding(12.dp)

        ){
            Image(
                painter = painterResource(id =place.imageResourceId),
                contentDescription = null,
//                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                )

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically)
            ){
                Text(
                    text = stringResource(place.name),
                    modifier = modifier
                        .padding(start = 28.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )
            }

        }
    }

}

