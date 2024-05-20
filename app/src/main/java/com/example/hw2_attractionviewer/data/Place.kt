package com.example.hw2_attractionviewer.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.hw2_attractionviewer.R

data class Place(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val introduction: Int,
    val latitude : Double = 0.0,
    val longitude : Double  = 0.0
)

val places = listOf(
    Place(R.drawable.place1, R.string.place_name_1, R.string.place_introduction_1, 26.2247, 119.9836),
    Place(R.drawable.place2, R.string.place_name_2, R.string.place_introduction_2, 26.2471, 120.0011),
    Place(R.drawable.place3, R.string.place_name_3, R.string.place_introduction_3, 26.1425, 119.92894),
    Place(R.drawable.place4, R.string.place_name_4, R.string.place_introduction_4, 26.160861, 119.916861),
    Place(R.drawable.place5, R.string.place_name_5, R.string.place_introduction_5, 25.964231550390103, 119.99057276603219),
    Place(R.drawable.place6, R.string.place_name_6, R.string.place_introduction_6, 25.97396689005268, 119.9304426525413),
    Place(R.drawable.place7, R.string.place_name_7, R.string.place_introduction_7,25.978575230944404, 119.94782193544083),
    Place(R.drawable.place8, R.string.place_name_8, R.string.place_introduction_8, 26.366104804675448, 120.50988507953929),
    Place(R.drawable.place9, R.string.place_name_9, R.string.place_introduction_9, 26.382810999728566, 120.47606816604876),
    Place(R.drawable.place10, R.string.place_name_10, R.string.place_introduction_10, 26.365025202698387, 120.49630299488435),
)
