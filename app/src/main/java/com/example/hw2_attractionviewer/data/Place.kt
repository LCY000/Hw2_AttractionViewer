package com.example.hw2_attractionviewer.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.hw2_attractionviewer.R

data class Place(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val introduction: Int
)

val places = listOf(
    Place(R.drawable.place1, R.string.place_name_1, R.string.place_introduction_1),
    Place(R.drawable.place2, R.string.place_name_2, R.string.place_introduction_2),
    Place(R.drawable.place3, R.string.place_name_3, R.string.place_introduction_3),
    Place(R.drawable.place4, R.string.place_name_4, R.string.place_introduction_4),
    Place(R.drawable.place5, R.string.place_name_5, R.string.place_introduction_5),
    Place(R.drawable.place6, R.string.place_name_6, R.string.place_introduction_6),
    Place(R.drawable.place7, R.string.place_name_7, R.string.place_introduction_7),
    Place(R.drawable.place8, R.string.place_name_8, R.string.place_introduction_8),
    Place(R.drawable.place9, R.string.place_name_9, R.string.place_introduction_9),
    Place(R.drawable.place10, R.string.place_name_10, R.string.place_introduction_10),
)
