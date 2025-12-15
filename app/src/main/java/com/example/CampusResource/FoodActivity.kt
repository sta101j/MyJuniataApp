package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Baker → Sections screen
        binding.cardBaker.setOnClickListener {
            startActivity(Intent(this, BakerSectionsActivity::class.java))
        }

        // Fisher
        binding.cardFisher.setOnClickListener {
            openCafe(
                name = "Fisher Cafe",
                address = "Ellis Hall",
                phone = "814-641-3000",
                email = "dining@juniata.edu",
                imageRes = R.drawable.fisher_cafe,
                website = "https://dev.juniata.edu/campus-life/dining.php"
            )
        }

        // Jitters
        binding.cardJitters.setOnClickListener {
            openCafe(
                name = "Jitters Cafe",
                address = "Baker Refectory, Juniata College",
                phone = "814-641-3000",
                email = "jitters@juniata.edu",
                imageRes = R.drawable.jitters_cafe,
                website = "https://dev.juniata.edu/campus-life/dining.php"
            )
        }

        // On the Go
        binding.cardOnTheGo.setOnClickListener {
            openCafe(
                name = "On the Go! Cafe",
                address = "Juniata College Campus",
                phone = "814-641-3000",
                email = "dining@juniata.edu",
                imageRes = R.drawable.on_the_go_cafe,
                website = "https://dev.juniata.edu/campus-life/dining.php"
            )
        }
    }

    private fun openCafe(
        name: String,
        address: String,
        phone: String,
        email: String,
        imageRes: Int = 0,
        website: String = ""
    ) {
        val intent = Intent(this, CafeDetailActivity::class.java).apply {
            putExtra("cafe_name", name)
            putExtra("cafe_address", address)
            putExtra("cafe_phone", phone)
            putExtra("cafe_email", email)
            putExtra("cafe_image", imageRes)
            putExtra("cafe_website", website)
        }
        startActivity(intent)
    }
}
