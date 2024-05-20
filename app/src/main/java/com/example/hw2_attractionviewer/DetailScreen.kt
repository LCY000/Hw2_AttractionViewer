package com.example.hw2_attractionviewer

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.hw2_attractionviewer.ui.theme.ViewerViewModel
import com.example.hw2_attractionviewer.data.places

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(
    modifier: Modifier = Modifier,
    @StringRes placeName : Int,

) {
    TopAppBar(
        title = { Text(stringResource(placeName)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    viewModel: ViewerViewModel,
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = { DetailAppBar(placeName = places[viewModel.getDataNumber()].name) }
    ){
        null
    }
}