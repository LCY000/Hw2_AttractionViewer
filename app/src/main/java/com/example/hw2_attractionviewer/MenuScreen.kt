package com.example.hw2_attractionviewer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    viewModel: ViewerViewModel
){
    Scaffold(
        topBar = { MenuAppBar() }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues){
            itemsIndexed(places){ index, place->
                PlaceCard(
                    place = place,
                    onClick = {viewModel.setDataNumber(index+1)},
                    modifier = Modifier.padding(8.dp)
                    )
            }
        }



    }
}


@Composable
fun PlaceCard(
    modifier: Modifier =Modifier,
    place: Place,
    onClick:()->Unit = {},
){
    Card(
        modifier= modifier.clickable { onClick() },
        shape = RoundedCornerShape(16.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Image(
                painter = painterResource(id =place.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(16.dp))
                )

            //還沒有景點名稱
        }
    }

}

