package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCoachingBinding

class CoachingDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413078")))
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:bakerb@juniata.edu")))
        }

        // 🧭 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Statton+Learning+Commons+Juniata+College+Huntingdon+PA")
                )
            )
        }

        // 🌐 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://outlook.office365.com/book/LearningServices@livejuniata.onmicrosoft.com/?ismsaljsauthenabled=true")
                )
            )
        }

        // 📅 Schedule block
        binding.btnSchedule.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://outlook.office365.com/book/LearningServices@livejuniata.onmicrosoft.com/?ismsaljsauthenabled=true")
                )
            )
        }
    }
}
