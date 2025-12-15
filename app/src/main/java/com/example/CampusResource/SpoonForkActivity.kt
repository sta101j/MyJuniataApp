package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivitySpoonForkBinding
import com.example.CampusResource.ui.MenuRenderer
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class SpoonForkActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpoonForkBinding
    private val dateFormatter = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US)

    // 🍔 SPOON & FORK — LUNCH BY DAY (WEEKDAYS ONLY)
    private val lunchByDayMap = mapOf(
        Calendar.MONDAY to listOf(
            "Beef Cheesesteak",
            "Baked Potato",
            "Battered Onion Rings",
            "Broccoli"
        ),
        Calendar.TUESDAY to listOf(
            "BBQ Pulled Pork",
            "Scalloped Potatoes",
            "Fresh Green Beans",
            "Hushpuppies"
        ),
        Calendar.WEDNESDAY to listOf(
            "Tuscan Sun-dried Tomato Chicken Stew (with pierogies)",
            "Rice Pilaf",
            "Ratatouille",
            "Roasted Root Vegetables"
        ),
        Calendar.THURSDAY to listOf(
            "Buffalo Chicken Wings",
            "Macaroni and Cheese",
            "Chili Lime Brussel Sprouts",
            "Dilled Carrots"
        ),
        Calendar.FRIDAY to listOf(
            "Pork Char Sui",
            "Vegetable Fried Rice",
            "Grilled Bok Choy",
            "Sweet & Sour Red Cabbage"
        )
    )

    // 🍽️ SPOON & FORK — DINNER BY DAY
    private val dinnerByDayMap = mapOf(
        Calendar.MONDAY to listOf(
            "3 Flames Sausage Chili",
            "Root Vegetable Creole",
            "Kickin’ Collard Greens",
            "Corn Muffin"
        ),
        Calendar.TUESDAY to listOf(
            "Sweet and Sticky Drumsticks",
            "Creamy Mashed Potatoes",
            "Sesame Garlic Asparagus",
            "Spicy Garlic Edamame"
        ),
        Calendar.WEDNESDAY to listOf(
            "Ham Pot Pie",
            "Peas with Pearl Onions",
            "Jalapeño Popper Dip",
            "Pita Wedges"
        ),
        Calendar.THURSDAY to listOf(
            "Cheese Ravioli",
            "Classic Bolognese Sauce",
            "Bread Sticks",
            "Creamed Spinach & Mushrooms",
            "Maple Glazed Parsnips & Carrots"
        ),
        Calendar.FRIDAY to listOf(
            "Beef Stroganoff",
            "Buttered Egg Noodles",
            "Cauliflower Parmesan",
            "Southern Style Succotash"
        ),
        Calendar.SATURDAY to listOf(
            "Grilled Honey Sriracha Chicken",
            "Steam Buns",
            "Stir Fry Vegetables",
            "Thai Coconut Rice"
        ),
        Calendar.SUNDAY to listOf(
            "Turkey Meatloaf",
            "Poultry Gravy",
            "Mashed Sweet Potatoes",
            "Fried Okra",
            "Vegetable Medley"
        )
    )

    // 🔹 CURRENT SELECTED DATE
    private var selectedCalendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpoonForkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ ENABLE CLICKABLE NUTRITION LINK
        binding.tvWeeklyNote.movementMethod = LinkMovementMethod.getInstance()
        binding.tvWeeklyNote.isClickable = true
        binding.tvWeeklyNote.isFocusable = true

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🔹 Header
        binding.tvHeader.text = "Spoon & Fork"
        binding.imgHeader.setImageResource(R.drawable.baker_eagle)

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413000")))
        }

        // 📧 Email
        binding.btnEmail.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:dining@juniata.edu")))
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

    // 🔄 CENTRAL MENU REFRESH
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

    // 🍳 BREAKFAST
    private fun breakfastByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Cheesy Scrambled Eggs",
                "Bacon",
                "French Toast Sticks",
                "Pork Sausage Link",
                "Spiced Breakfast Potatoes"
            )
            Calendar.TUESDAY -> listOf(
                "Pancakes",
                "Cheesy Scrambled Eggs",
                "Spiced Breakfast Potatoes",
                "Turkey Sausage Link",
                "Bacon"
            )
            Calendar.WEDNESDAY -> listOf(
                "Cheesy Scrambled Eggs",
                "Cream Cheese Cinnamon Rolls",
                "Hashbrown Patty",
                "Pork Sausage Link",
                "Bacon"
            )
            Calendar.THURSDAY -> listOf(
                "Cheese Blintz",
                "Cheesy Scrambled Eggs",
                "Spiced Breakfast Potatoes",
                "Chicken Sausage Patty",
                "Bacon"
            )
            Calendar.FRIDAY -> listOf(
                "French Toast",
                "Cheesy Scrambled Eggs",
                "Tater Tots",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.SATURDAY -> listOf(
                "French Toast Sticks",
                "Spiced Breakfast Potatoes",
                "Bacon",
                "Pork Sausage Link"
            )
            Calendar.SUNDAY -> listOf(
                "BYO – Breakfast Sandwich",
                "Bacon",
                "Pork Sausage Link",
                "Spiced Breakfast Potatoes",
                "Buttermilk Biscuit",
                "Sausage Gravy",
                "Corned Beef Hash"
            )
            else -> emptyList()
        }

    // 🍔 LUNCH
    private fun lunchByDay(day: Int): List<String> =
        when (day) {
            Calendar.SATURDAY, Calendar.SUNDAY ->
                listOf("Lunch service unavailable (Dining closed)")
            else ->
                lunchByDayMap[day] ?: emptyList()
        }

    // 🍽️ DINNER
    private fun dinnerByDay(day: Int): List<String> =
        dinnerByDayMap[day] ?: emptyList()
}
