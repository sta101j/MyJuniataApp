package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCafeDetailBinding

class CafeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCafeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCafeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data
        val name = intent.getStringExtra("cafe_name") ?: "Cafe"
        val address = intent.getStringExtra("cafe_address") ?: ""
        val phone = intent.getStringExtra("cafe_phone") ?: ""
        val email = intent.getStringExtra("cafe_email") ?: ""
        val website = intent.getStringExtra("cafe_website") ?: ""
        val imageRes = intent.getIntExtra("cafe_image", 0)

        // Populate UI
        binding.tvHeader.text = name
        binding.tvCafeName.text = name
        binding.tvAddress.text = address
        binding.tvPhone.text = phone
        binding.tvEmail.text = email

        // Set image if provided
        if (imageRes != 0) {
            binding.imgCafe.setImageResource(imageRes)
        }

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Call
        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
        }

        // Email
        binding.btnEmail.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")))
        }

        // Directions
        binding.btnDirections.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=$address")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        // Website
        binding.btnWebsite.setOnClickListener {
            if (website.isNotEmpty()) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(website)))
            }
        }
    }
}
