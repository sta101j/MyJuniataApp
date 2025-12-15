package com.example.CampusResource.model

enum class MealType {
    BREAKFAST, LUNCH, DINNER
}

data class MenuItem(
    val name: String,
    val meal: MealType
)
