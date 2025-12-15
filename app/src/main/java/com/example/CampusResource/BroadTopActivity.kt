package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityBroadTopBinding

class BroadTopActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBroadTopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadTopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Call
        binding.actionCall.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146433205"))
            )
        }

        binding.actionEmail.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_SENDTO,
                    Uri.parse("mailto:broadtop@juniata.edu")
                )
            )
        }

        // Directions → Google Maps
        binding.actionDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=419+14th+Street,+Huntingdon,+PA+16652")
                )
            )
        }

        // Website
        binding.actionWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/offices/health/")
                )
            )
        }
    }
}
