package com.vaipraa.assement.core.presentation.activity

import androidx.recyclerview.widget.RecyclerView

data class SelectedMeals(
    var segmentId: Int = RecyclerView.NO_POSITION, var mealId: Int = RecyclerView.NO_POSITION
)