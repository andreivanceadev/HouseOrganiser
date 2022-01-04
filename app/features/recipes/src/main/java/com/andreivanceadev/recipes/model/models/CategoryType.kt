package com.andreivanceadev.recipes.model.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class CategoryType(val id: Int, val categoryName: String) : Parcelable {
    ALL(0, "All"),
    BREAKFAST(1, "Breakfast"),
    LUNCH(2, "Lunch"),
    DINNER(3, "Dinner"),
    SNACK(4, "Snack");

    companion object {
        fun getById(id: Int): CategoryType {
            return when (id) {
                1 -> BREAKFAST
                2 -> LUNCH
                3 -> DINNER
                4 -> SNACK
                else -> throw RuntimeException("Category id doesn't exist")
            }
        }

        fun getByName(name: String): CategoryType {
            return when (name) {
                ALL.categoryName -> ALL
                BREAKFAST.categoryName -> BREAKFAST
                LUNCH.categoryName -> LUNCH
                DINNER.categoryName -> DINNER
                SNACK.categoryName -> SNACK
                else -> throw RuntimeException("Category name doesn't exist")
            }
        }
    }
}
