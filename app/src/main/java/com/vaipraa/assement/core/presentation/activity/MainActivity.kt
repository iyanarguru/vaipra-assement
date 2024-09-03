package com.vaipraa.assement.core.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.vaipraa.assement.core.GenericAdapter
import com.vaipraa.assement.R
import com.vaipraa.assement.core.presentation.viewmodel.MainViewModel
import com.vaipraa.assement.databinding.ActivityMainBinding
import com.vaipraa.assement.databinding.ItemMealBinding
import com.vaipraa.assement.databinding.ItemSegmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var mealAdapter: GenericAdapter<Meal>? = null
    private var segmentAdapter: GenericAdapter<Segment>? = null
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        binding.btnProceed.setOnClickListener {
            if (viewModel.currentSegmentId < viewModel.segments.size) {
                viewModel.segments.map { it.isSelected = false }
                viewModel.segments[viewModel.currentSegmentId].isSelected = true
                viewModel.currentSegmentId += 1
                viewModel.meals.forEach {
                    if (!it.isSelected) it.segmentId = viewModel.currentSegmentId
                }
                segmentAdapter?.submitData(viewModel.segments)
                binding.rvSegment.scrollToPosition(viewModel.currentSegmentId+1)

            }
        }
        segmentAdapter = GenericAdapter(itemList = viewModel.segments,
            layoutResId = R.layout.item_segment,
            bind = { item, binding ->
                if (binding is ItemSegmentBinding) {
                    if (item.isSelected) {
                        binding.trip.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                this, R.drawable.selected_rounded_corner
                            )
                        )
                    } else {
                        binding.trip.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                this, R.drawable.unselected_rounded_corner
                            )
                        )
                    }
                }
            },
            onItemClick = { item ->
                viewModel.currentSegmentId = item.id
                viewModel.meals.forEach { if (!it.isSelected) it.segmentId = item.id }
                viewModel.segments.map { it.isSelected = it.id == item.id }
                segmentAdapter?.submitData(viewModel.segments)
            }).apply {
            binding.rvSegment.adapter = this@apply
        }

        mealAdapter = GenericAdapter(itemList = viewModel.meals,
            layoutResId = R.layout.item_meal,
            bind = { item, binding ->
                if (binding is ItemMealBinding) {
                    binding.addButton.apply {
                        text = if (item.isSelected) "Remove" else "Add"
                    }
                    if (item.isSelected) {
                        binding.rootLayout.background = ResourcesCompat.getDrawable(
                            resources, R.drawable.selected_rounded_corner, null
                        )
                    } else {
                        binding.rootLayout.background = ResourcesCompat.getDrawable(
                            resources, R.drawable.unselected_rounded_corner, null
                        )
                    }
                    binding.foodName.text = item.name
                }
            },
            onItemClick = { meal ->
                val segmentBasedSelectedMeals =
                    viewModel.selectedMeals.filter { selectedMealsArray -> selectedMealsArray.segmentId == viewModel.currentSegmentId }


                if (meal.segmentId == viewModel.currentSegmentId) {
                    if (segmentBasedSelectedMeals.isNotEmpty()) {
                        //un select the selected meal
                        if (segmentBasedSelectedMeals.first().mealId == meal.id) {
                            viewModel.selectedMeals.remove(segmentBasedSelectedMeals.first())


                            viewModel.meals.map { if (it.id == meal.id) it.isSelected = false }
                            mealAdapter?.submitData(viewModel.meals)
                        } else {
                            Toast.makeText(
                                this, "You can select only one meal per segment", Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        viewModel.selectedMeals.add(
                            SelectedMeals(
                                mealId = meal.id, segmentId = viewModel.currentSegmentId
                            )
                        )

                        // update ui
                        viewModel.meals.map { if (it.id == meal.id) it.isSelected = true }
                        mealAdapter?.submitData(viewModel.meals)

                    }
                } else {
                    Toast.makeText(
                        this, "You can't deselect another segment meal", Toast.LENGTH_SHORT
                    ).show()
                }

            }).apply {
            binding.rvMealsList.adapter = this@apply
        }
    }

}

data class Segment(
    val id: Int,
    val name: String,
    var isSelected: Boolean,
)

data class SelectedMeals(
    var segmentId: Int = RecyclerView.NO_POSITION, var mealId: Int = RecyclerView.NO_POSITION
)

data class Meal(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String,
    var isSelected: Boolean,
    var segmentId: Int
)