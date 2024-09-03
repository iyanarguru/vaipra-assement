package com.vaipraa.assement.core.presentation.activity

data class Meal(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String,
    var isSelected: Boolean,
    var segmentId: Int
)