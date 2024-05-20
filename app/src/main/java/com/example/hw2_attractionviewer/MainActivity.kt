package com.example.hw2_attractionviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hw2_attractionviewer.ui.theme.Hw2_AttractionViewerTheme
import com.example.hw2_attractionviewer.ui.theme.ViewerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw2_AttractionViewerTheme {
                    ViewerApp()
            }
        }
    }
}

@Composable
fun ViewerApp(
    viewModel: ViewerViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "menuPage"){
        //初始景點瀏覽頁
        composable("menuPage"){
            MenuScreen(viewModel, navController)
        }
        //景點詳細資訊頁
        composable("detailPage"){
            DetailScreen(viewModel, navController)
        }

    }

}


