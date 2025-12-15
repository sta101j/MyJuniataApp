package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityClubsOrganizationsBinding

class ClubsOrganizationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubsOrganizationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClubsOrganizationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413330"))
            )
        }

        // Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:campuslife@juniata.edu")
                )
            )
        }

        // Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Ellis+Hall+Juniata+College")
                )
            )
        }

        // Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/offices/student-engagement-and-campus-activities/clubs-organizations/")
                )
            )
        }
    }
}
