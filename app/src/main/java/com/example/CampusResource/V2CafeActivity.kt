package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityV2CafeBinding
import com.example.CampusResource.ui.MenuRenderer
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class V2CafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityV2CafeBinding
    private val dateFormatter = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US)

    // 📅 SELECTED DATE
    private var selectedCalendar: Calendar = Calendar.getInstance()

    // 🍳 V2 — BREAKFAST
    private fun breakfastByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Breakfast Sandwich",
                "Spiced Breakfast Potatoes",
                "Vegan Omelet Bar"
            )
            Calendar.TUESDAY -> listOf(
                "Scrambled Tofu Breakfast Tacos",
                "Tater Tots",
                "Vegan Omelet Bar"
            )
            Calendar.WEDNESDAY -> listOf(
                "Allergen Free Cinnamon Roll Cake",
                "AcreMade Eggs",
                "Vegan Omelet Bar"
            )
            Calendar.THURSDAY -> listOf(
                "Baked Oatmeal with Blueberries",
                "Hashbrown Patty",
                "Vegan Omelet Bar"
            )
            Calendar.FRIDAY -> listOf(
                "Vegan Buckwheat Pancakes",
                "Sweet Potato Hash",
                "Vegan Omelet Bar"
            )
            Calendar.SATURDAY -> listOf(
                "Breakfast service unavailable (V2 closed)"
            )
            Calendar.SUNDAY -> listOf(
                "Curried Tofu Spinach Scramble",
                "Herb & Vegetable Hash w Rice"
            )
            else -> emptyList()
        }

    // 🍴 V2 — LUNCH (WEEKDAYS ONLY)
    private fun lunchByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Channa Masala",
                "Basmati Rice",
                "Citrus Spiced Carrots"
            )
            Calendar.TUESDAY -> listOf(
                "Grilled Cheese & Tomato",
                "Creamy Tomato Soup",
                "Tater Tots"
            )
            Calendar.WEDNESDAY -> listOf(
                "BBQ Tofu",
                "Vegan Mashed Potatoes",
                "BBQ Vegetarian Baked Beans"
            )
            Calendar.THURSDAY -> listOf(
                "Sesame Tofu Vegetable Stir Fry",
                "Soba Noodles",
                "Chinese Green Beans"
            )
            Calendar.FRIDAY -> listOf(
                "Falafel",
                "Garlic Herb Orzo",
                "Zucchini Cherry Tomato Sauté"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Lunch service unavailable (V2 closed)"
            )
            else -> emptyList()
        }

    // 🍽️ V2 — DINNER
    private fun dinnerByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Cajun Red Bean Rice Patty",
                "Corn",
                "Vegetable Medley"
            )
            Calendar.TUESDAY -> listOf(
                "Caribbean Style Stewed Lentils",
                "Fried Jerk Plantain",
                "Black Beans"
            )
            Calendar.WEDNESDAY -> listOf(
                "Marinated Southwest Jackfruit",
                "Oven Roasted Tomato",
                "Vegan Butter Cauliflower"
            )
            Calendar.THURSDAY -> listOf(
                "Spinach & Cheese Calzone",
                "Portobello Florentine Pasta Bake"
            )
            Calendar.FRIDAY -> listOf(
                "Mushroom Marsala",
                "Garden Wild Rice",
                "Garlic Bread"
            )
            Calendar.SATURDAY -> listOf(
                "Orange Roasted Tofu with Asparagus",
                "White Rice"
            )
            Calendar.SUNDAY -> listOf(
                "Polenta Pie with Rice Beans Salsa",
                "Spanish Rice"
            )
            else -> emptyList()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityV2CafeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🔹 Header
        binding.tvHeader.text = "V2 Café"
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
