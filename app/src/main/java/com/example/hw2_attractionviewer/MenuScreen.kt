package com.example.hw2_attractionviewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.hw2_attractionviewer.data.Place
import com.example.hw2_attractionviewer.data.places
import com.example.hw2_attractionviewer.ui.theme.ViewerViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuAppBar(
    modifier: Modifier = Modifier
) {
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
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { MenuAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues){
            itemsIndexed(places){ index, place->
                PlaceCard(
                    place = place,
                    onClick = {viewModel.setDataNumber(index)},
                    modifier = modifier.padding(8.dp)
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
        modifier= modifier
            .clickable(
                onClick = { onClick() },
//                interactionSource = remember { MutableInteractionSource() },  //按鈕按下去的反饋怪怪的，不是圓角
//                indication = rememberRipple(bounded = true)
            ),

    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)

        ){
            Image(
                painter = painterResource(id =place.imageResourceId),
                contentDescription = null,
//                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(70.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(16.dp))
                )

            //還沒有景點名稱
            Text(
                text = stringResource(place.name),
                modifier = Modifier
                    .padding(vertical= 12.dp)
                    .padding(start = 24.dp)
                    .fillMaxSize(),
                textAlign = TextAlign.Start,
                fontSize = 20.sp
            )
        }
    }

}

