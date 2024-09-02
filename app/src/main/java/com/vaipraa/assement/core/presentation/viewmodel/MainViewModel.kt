package com.vaipraa.assement.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.vaipraa.assement.R
import com.vaipraa.assement.core.presentation.activity.Meal
import com.vaipraa.assement.core.presentation.activity.Segment
import com.vaipraa.assement.core.presentation.activity.SelectedMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {

    var currentSegmentId = 1

    val segments = listOf(
        Segment(id = 1, "PNQ - DCQ", isSelected = true),
        Segment(id = 2, name = "DCQ - PNQ", isSelected = false),
        Segment(id = 3, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 4, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 5, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 6, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 7, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 8, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 9, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 10, name = "DCQ - PNQ", isSelected = false),
//        Segment(id = 11, name = "DCQ - PNQ", isSelected = false),
    )

    val meals = listOf(
        Meal(
            id = 1,
            image = R.drawable.meal_icon,
            name = "Coke",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 2,
            image = R.drawable.meal_icon,
            name = "Coke1",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke2",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 4,
            image = R.drawable.meal_icon,
            name = "Coke3",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 5,
            image = R.drawable.meal_icon,
            name = "Coke4",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke6",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke7",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Coke5",
            price = "$200",
            isSelected = false,
            segmentId = 1
        ),
    )

    val selectedMeals = arrayListOf<SelectedMeals>()


}