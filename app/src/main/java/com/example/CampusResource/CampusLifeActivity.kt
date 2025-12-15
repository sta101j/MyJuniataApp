package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCampusLifeBinding

class CampusLifeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCampusLifeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCampusLifeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:8775864282")
                )
            )
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:info@juniata.edu")
                )
            )
        }

        // 🧭 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=1700+Moore+Street+Huntingdon+PA+16652")
                )
            )
        }

        // 🌍 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/campus-life/")
                )
            )
        }
    }
}
