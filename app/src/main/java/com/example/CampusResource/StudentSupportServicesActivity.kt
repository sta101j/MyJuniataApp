package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityStudentSupportServicesBinding

class StudentSupportServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentSupportServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentSupportServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:8146415840")
                )
            )
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:accessibility@juniata.edu")
                )
            )
        }

        // 🧭 Directions (Good Hall, Juniata)
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Good+Hall+Juniata+College+Huntingdon+PA")
                )
            )
        }

        // 🌍 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://connect.juniata.edu/student-accessibility-services/index.php")
                )
            )
        }
    }
}
