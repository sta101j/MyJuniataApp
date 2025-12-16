package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // =========================
        // INITIAL STATE: SHOW WELCOME
        // =========================
        binding.welcomeContainer.visibility = View.VISIBLE
        binding.homeContainer.visibility = View.GONE

        // After short delay, show Home
        Handler(Looper.getMainLooper()).postDelayed({
            binding.welcomeContainer.animate()
                .alpha(0f)
                .setDuration(300)
                .withEndAction {
                    binding.welcomeContainer.visibility = View.GONE
                    binding.homeContainer.visibility = View.VISIBLE
                }
        }, 1200)

        setupHomeActions()
    }

    // =========================
    // HOME SCREEN LOGIC
    // =========================
    private fun setupHomeActions() {

        // 🔍 SEARCH BAR
        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                handleSearch(binding.etSearch.text.toString())
                true
            } else false
        }

        // Find Buildings
        binding.btnFindBuildings.setOnClickListener {
            startActivity(Intent(this, BuildingListActivity::class.java))
        }

        // Food
        binding.btnFood.setOnClickListener {
            startActivity(Intent(this, FoodActivity::class.java))
        }

        // Accessibility
        binding.btnAccessibility.setOnClickListener {
            startActivity(Intent(this, AccessibilityActivity::class.java))
        }

        // Fleet
        findViewById<LinearLayout>(R.id.btnFleetBooking).setOnClickListener {
            startActivity(Intent(this, FleetActivity::class.java))
        }

        // Health
        binding.btnHealth.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }

        // Careers
        binding.btnCareers.setOnClickListener {
            startActivity(Intent(this, CareersActivity::class.java))
        }

        // Finances
        binding.btnFinances.setOnClickListener {
            startActivity(Intent(this, FinancesActivity::class.java))
        }

        // Diversity
        binding.btnDiversity.setOnClickListener {
            startActivity(Intent(this, DiversityActivity::class.java))
        }

        // Academics – Coming Soon
        binding.btnAcademics.setOnClickListener {
            startActivity(Intent(this, AcademicsActivity::class.java))
        }




        binding.btnStudentServices.setOnClickListener {
            startActivity(Intent(this, StudentServicesActivity::class.java))
        }

    }

    // =========================
    // SEARCH ROUTING
    // =========================
    private fun handleSearch(query: String) {
        val text = query.trim().lowercase()

        when {
            text.contains("campus") || text.contains("life") ->
                startActivity(Intent(this, CampusLifeActivity::class.java))

            text.contains("diversity") || text.contains("inclusion") ->
                startActivity(Intent(this, DiversityActivity::class.java))

            text.contains("career") ->
                startActivity(Intent(this, CareersActivity::class.java))

            text.contains("finance") || text.contains("tuition") || text.contains("bursar") ->
                startActivity(Intent(this, FinancesActivity::class.java))

            text.contains("health") || text.contains("wellness") ->
                startActivity(Intent(this, HealthActivity::class.java))

            text.contains("accessibility") ->
                startActivity(Intent(this, AccessibilityActivity::class.java))

            text.contains("fleet") || text.contains("vehicle") ->
                startActivity(Intent(this, FleetActivity::class.java))

            text.contains("food") || text.contains("dining") ->
                startActivity(Intent(this, FoodActivity::class.java))

            text.contains("building") || text.contains("map") ->
                startActivity(Intent(this, BuildingListActivity::class.java))

            else ->
                Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show()
        }
    }
}
