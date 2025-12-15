package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCleanPlateBinding
import com.example.CampusResource.ui.MenuRenderer
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class CleanPlateCafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCleanPlateBinding
    private val dateFormatter = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US)
    private var selectedCalendar: Calendar = Calendar.getInstance()

    // 🥞 CLEAN PLATE — BREAKFAST
    private fun breakfastByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Housemade Pancakes",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.TUESDAY -> listOf(
                "Gluten & Allergen Free Waffle Mix",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.WEDNESDAY -> listOf(
                "Classic French Toast",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.THURSDAY -> listOf(
                "Berry Lover Smoothie",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.FRIDAY -> listOf(
                "Sweet Potato & Chicken Breakfast Muffin",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "American Grill Burger",
                "Black Bean Burger",
                "Dr Pepper BBQ Turkey Burger",
                "Green Fruit Smoothie",
                "Clean Plate Omelet Bar",
                "Bacon",
                "Pork Sausage Link"
            )
            else -> emptyList()
        }

    // 🍴 CLEAN PLATE — LUNCH
    private fun lunchByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Rosemary Garlic Chicken",
                "Garden Wild Rice",
                "JC Steamed Broccoli"
            )
            Calendar.TUESDAY -> listOf(
                "Zesty Orange Lamb Kebabs",
                "Basmati Rice",
                "Roasted Green Beans"
            )
            Calendar.WEDNESDAY -> listOf(
                "Chicken & Butternut Squash Curry",
                "White Rice",
                "Stir Fry Vegetables"
            )
            Calendar.THURSDAY -> listOf(
                "Blackened Chicken Wings",
                "Mexican Quinoa",
                "Grilled Asparagus"
            )
            Calendar.FRIDAY -> listOf(
                "Autumn Cranberry Beef Stew",
                "Brown Rice",
                "Vegetable Medley"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Lunch service unavailable (Clean Plate closed)"
            )
            else -> emptyList()
        }

    // 🍽️ CLEAN PLATE — DINNER
    private fun dinnerByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Orange Beef Stir Fry",
                "Brown Rice"
            )
            Calendar.TUESDAY -> emptyList()
            Calendar.WEDNESDAY -> listOf(
                "Brazilian Chicken in Wine Sauce",
                "Maple Roasted Sweet Potatoes",
                "Lima Beans"
            )
            Calendar.THURSDAY -> listOf(
                "Coffee & Molasses Pork Chop",
                "White Rice",
                "Oven Roasted Spiced Carrots"
            )
            Calendar.FRIDAY -> listOf(
                "Spaghetti & Monster Meatballs",
                "Roasted Cherry Tomato"
            )
            Calendar.SATURDAY -> listOf(
                "Aglio e Olio Pasta",
                "Pizza Polenta Bowl"
            )
            Calendar.SUNDAY -> listOf(
                "Chicken Cacciatore Italiano",
                "Italian Roasted Potatoes",
                "Roasted Mushrooms & Peas"
            )
            else -> emptyList()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCleanPlateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🔹 Header
        binding.tvHeader.text = "Clean Plate"
        binding.imgHeader.setImageResource(R.drawable.baker_eagle)

        // ✅ ENABLE CLICKABLE NUTRITION LINK
        binding.tvWeeklyNote.movementMethod = LinkMovementMethod.getInstance()
        binding.tvWeeklyNote.isClickable = true
        binding.tvWeeklyNote.isFocusable = true

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:8146413000")
                )
            )
        }

        // 📧 Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:dining@juniata.edu")
                )
            )
        }

        // 🌐 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://dev.juniata.edu/campus-life/dining.php")
                )
            )
        }

        // 📍 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Juniata+College+Campus")
                )
            )
        }

        // 📅 DEFAULT DATE = TODAY
        selectedCalendar = Calendar.getInstance()
        binding.tvSelectedDate.text = dateFormatter.format(selectedCalendar.time)

        // 📅 CALENDAR PICKER
        binding.btnCalendar.setOnClickListener {

            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .setSelection(selectedCalendar.timeInMillis)
                .build()

            datePicker.addOnPositiveButtonClickListener { millis ->

                val utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                utcCalendar.timeInMillis = millis

                selectedCalendar = Calendar.getInstance().apply {
                    set(
                        utcCalendar.get(Calendar.YEAR),
                        utcCalendar.get(Calendar.MONTH),
                        utcCalendar.get(Calendar.DAY_OF_MONTH)
                    )
                }

                binding.tvSelectedDate.text =
                    dateFormatter.format(selectedCalendar.time)

                refreshMenu()
            }

            datePicker.show(supportFragmentManager, "DATE_PICKER")
        }

        // 🔽 DEFAULT: Breakfast
        binding.mealToggleGroup.check(R.id.btnBreakfast)
        refreshMenu()

        // 🔁 MEAL TOGGLE
        binding.mealToggleGroup.addOnButtonCheckedListener { _, _, isChecked ->
            if (isChecked) refreshMenu()
        }
    }

    // 🔄 CENTRAL MENU REFRESH (STANDARDIZED)
    private fun refreshMenu() {
        val day = selectedCalendar.get(Calendar.DAY_OF_WEEK)

        val menu = when (binding.mealToggleGroup.checkedButtonId) {
            R.id.btnBreakfast -> breakfastByDay(day)
            R.id.btnLunch -> lunchByDay(day)
            R.id.btnDinner -> dinnerByDay(day)
            else -> emptyList()
        }

        MenuRenderer.render(this, binding.menuContainer, menu)
    }
}
