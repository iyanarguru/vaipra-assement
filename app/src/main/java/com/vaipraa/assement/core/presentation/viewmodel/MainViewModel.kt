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
    )

    val meals = listOf(
        Meal(
            id = 1,
            image = R.drawable.meal_icon,
            name = "Vegetable Sandwich",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 2,
            image = R.drawable.meal_icon,
            name = "Veg Kebab Roll",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 3,
            image = R.drawable.meal_icon,
            name = "Coke 300 ML",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 4,
            image = R.drawable.meal_icon,
            name = "Salad",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 5,
            image = R.drawable.meal_icon,
            name = "Kiddie Delight",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 6,
            image = R.drawable.meal_icon,
            name = "Low calorie veg",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 7,
            image = R.drawable.meal_icon,
            name = "Non Veg Biryani",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 8,
            image = R.drawable.meal_icon,
            name = "Veg Biryani",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 9,
            image = R.drawable.meal_icon,
            name = "Chicken Soup",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 10,
            image = R.drawable.meal_icon,
            name = "Veg Soup",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 11,
            image = R.drawable.meal_icon,
            name = "Vegetable Sandwich",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 12,
            image = R.drawable.meal_icon,
            name = "Veg Kebab Roll",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 13,
            image = R.drawable.meal_icon,
            name = "Coke 500 ML",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 14,
            image = R.drawable.meal_icon,
            name = "Salad",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 15,
            image = R.drawable.meal_icon,
            name = "Kiddie Delight",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 16,
            image = R.drawable.meal_icon,
            name = "Low calorie veg",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 17,
            image = R.drawable.meal_icon,
            name = "Non Veg Biryani",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 18,
            image = R.drawable.meal_icon,
            name = "Veg Biryani",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 19,
            image = R.drawable.meal_icon,
            name = "Chicken Soup",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
        Meal(
            id = 20,
            image = R.drawable.meal_icon,
            name = "Veg Soup",
            price = "₹250",
            isSelected = false,
            segmentId = 1
        ),
    )

    val selectedMeals = arrayListOf<SelectedMeals>()


}