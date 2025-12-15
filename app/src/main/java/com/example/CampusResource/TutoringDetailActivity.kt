package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityTutoringBinding

class TutoringDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutoringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTutoringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:8146413078")
                )
            )
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:tutoring@juniata.edu")
                )
            )
        }

        // 🧭 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "geo:0,0?q=Statton+Learning+Commons+Juniata+College+Huntingdon+PA"
                    )
                )
            )
        }

        // 🌍 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://connect.juniata.edu/academics/departments/international/english-for-academic-purposes/tutoring-services.php"
                    )
                )
            )
        }
    }
}
