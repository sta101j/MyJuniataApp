package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityBravoBinding
import com.example.CampusResource.ui.MenuRenderer
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class BravoCafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBravoBinding
    private val dateFormatter = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US)
    private var selectedCalendar: Calendar = Calendar.getInstance()

    // 🍳 BREAKFAST — BRAVO (CLOSED ALL DAYS)
    private fun breakfastByDay(day: Int): List<String> =
        listOf("Breakfast service unavailable")

    // 🍴 LUNCH — BRAVO
    private fun lunchByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY -> listOf(
                "Pierogi Bar",
                "Bahn Mi Hot Dogs"
            )
            Calendar.TUESDAY -> listOf(
                "Mongolian Stir Fry"
            )
            Calendar.WEDNESDAY -> listOf(
                "Grilled Cheese Bar",
                "Island Styled Fried Rice"
            )
            Calendar.THURSDAY,
            Calendar.FRIDAY -> listOf(
                "Mongolian Stir Fry"
            )
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Lunch service unavailable"
            )
            else -> emptyList()
        }

    // 🍽️ DINNER — BRAVO
    private fun dinnerByDay(day: Int): List<String> =
        when (day) {
            Calendar.MONDAY,
            Calendar.WEDNESDAY -> listOf(
                "Mongolian Stir Fry",
                "JC Mongolian Stir Fry"
            )
            Calendar.TUESDAY -> listOf(
                "Quesadilla Bar",
                "Spicy Salmon Cakes"
            )
            Calendar.THURSDAY -> listOf(
                "Breakfast After Dark"
            )
            Calendar.FRIDAY,
            Calendar.SATURDAY,
            Calendar.SUNDAY -> listOf(
                "Dinner service unavailable"
            )
            else -> emptyList()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBravoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🔹 Header
        binding.tvHeader.text = "Bravo"
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

    // 🔄 CENTRAL MENU REFRESH (IDENTICAL TO SPOON & FORK)
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
