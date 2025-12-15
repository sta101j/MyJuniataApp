package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCareerDetailBinding

class CareerDetailJSandGSP : AppCompatActivity() {

    private lateinit var binding: ActivityCareerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCareerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🧭 Header
        binding.tvHeader.text = "Job Search and Graduate School Preparation"

        // 🖼️ Header Image
        binding.imgHeader.setImageResource(R.drawable.founderhall_careers)

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:8146413000")
                )
            )
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:careerdevelopment@juniata.edu")
                )
            )
        }

        // 🧭 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Founders+Hall+Huntingdon+PA+16652")
                )
            )
        }

        // 🌍 Website / Map
        binding.actionWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://maps.google.com/?q=Founders+Hall+Huntingdon+PA+16652")
                )
            )
        }
    }
}
