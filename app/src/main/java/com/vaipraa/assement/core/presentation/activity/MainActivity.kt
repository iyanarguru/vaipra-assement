package com.vaipraa.assement.core.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.vaipraa.assement.R
import com.vaipraa.assement.core.GenericAdapter
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
                binding.rvMealsList.smoothScrollToPosition(0)
            } else {
                showToast(getString(R.string.no_more_segment_available))
            }
        }
        segmentAdapter = GenericAdapter(itemList = viewModel.segments,
            layoutResId = R.layout.item_segment,
            bind = { item, binding ->
                if (binding is ItemSegmentBinding) {
                    binding.apply {
                        trip.text = item.name
                        trip.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                this@MainActivity,
                                if (item.isSelected) R.drawable.selected_rounded_corner else R.drawable.unselected_rounded_corner
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
                binding.rvMealsList.smoothScrollToPosition(0)
            }).apply {
            binding.rvSegment.adapter = this@apply
        }

        mealAdapter = GenericAdapter(itemList = viewModel.meals,
            layoutResId = R.layout.item_meal,
            bind = { item, binding ->
                if (binding is ItemMealBinding) {
                    binding.apply {
                        addButton.apply {
                            text =
                                if (item.isSelected) getString(R.string.remove) else getString(R.string.add)
                        }
                        foodPrice.apply {
                            text = item.price
                        }
                        rootLayout.background = ResourcesCompat.getDrawable(
                            resources,
                            if (item.isSelected) R.drawable.selected_rounded_corner else R.drawable.unselected_rounded_corner,
                            null
                        )
                        foodName.text = item.name
                    }
                }
            },
            onItemClick = { meal ->
                val segmentBasedSelectedMeals =
                    viewModel.selectedMeals.filter { selectedMealsArray -> selectedMealsArray.segmentId == viewModel.currentSegmentId }


                if (meal.segmentId == viewModel.currentSegmentId) {
                    if (segmentBasedSelectedMeals.isNotEmpty()) {
                        //un select the selected meal
                        if (segmentBasedSelectedMeals.first().mealId == meal.id) {
                            removeSelectedItem(segmentBasedSelectedMeals, meal)
                        } else {
                            showToast(getString(R.string.you_can_select_only_one_meal_per_segment))
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
                    showToast(getString(R.string.you_can_t_deselect_another_segment_meal))
                }

            }).apply {
            binding.rvMealsList.adapter = this@apply
        }
    }

    private fun removeSelectedItem(
        segmentBasedSelectedMeals: List<SelectedMeals>, meal: Meal
    ) {
        viewModel.selectedMeals.remove(segmentBasedSelectedMeals.first())
        viewModel.meals.map { if (it.id == meal.id) it.isSelected = false }
        mealAdapter?.submitData(viewModel.meals)
    }

    private fun showToast(alertContent: String) {
        Toast.makeText(this, alertContent, Toast.LENGTH_SHORT).show()
    }
}


