package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityWritingCenterBinding

class WritingCenterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWritingCenterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413501"))
            )
        }

        // Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:writing@juniata.edu"))
            )
        }

        // Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Statton+Learning+Commons+Juniata+College")
                )
            )
        }

        // Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/academics/writing-center/index.php")
                )
            )
        }
    }
}
