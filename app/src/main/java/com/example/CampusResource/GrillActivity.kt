package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityGrillBinding
import com.example.CampusResource.ui.MenuRenderer
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class GrillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGrillBinding
    private val dateFormatter = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US)

    // 📅 SELECTED DATE
    private var selectedCalendar: Calendar = Calendar.getInstance()

    // 🍳 GRILL — BREAKFAST
    private fun breakfastByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY,
            Calendar.TUESDAY,
            Calendar.WEDNESDAY -> listOf(
                "BYO – Breakfast Sandwich",
                "Eggs to Order",
                "Omelet Bar"
            )
            Calendar.THURSDAY,
            Calendar.FRIDAY -> listOf(
                "Eggs to Order",
                "Omelet Bar",
                "BYO – Breakfast Sandwich"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Eggs to Order",
                "Hand Cut French Fries",
                "Omelet Bar"
            )
            else -> emptyList()
        }

    // 🍴 GRILL — LUNCH
    private fun lunchByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Hot Italian Beef Sandwich",
                "Grilled Chicken Breast",
                "Grilled Cheese Sandwich",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.TUESDAY -> listOf(
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries",
                "Grilled Cheddar Cheese Sandwich"
            )
            Calendar.WEDNESDAY -> listOf(
                "Breakfast Sausage Patty Melt",
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.THURSDAY -> listOf(
                "Rodeo Burger",
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.FRIDAY -> listOf(
                "Hot Italian Sausage Sandwich",
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Lunch service unavailable (Grill closed)"
            )
            else -> emptyList()
        }

    // 🍽️ GRILL — DINNER
    private fun dinnerByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Hot Italian Beef Sandwich",
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.TUESDAY -> listOf(
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries",
                "Grilled Cheddar Cheese Sandwich"
            )
            Calendar.WEDNESDAY -> listOf(
                "Breakfast Sausage Patty Melt",
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Grilled Cheese Sandwich",
                "Grilled Chicken Breast",
                "Hamburger",
                "Hand Cut French Fries"
            )
            else -> listOf(
                "Dinner service unavailable"
            )
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGrillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🔹 Header
        binding.tvHeader.text = "Grill"
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
