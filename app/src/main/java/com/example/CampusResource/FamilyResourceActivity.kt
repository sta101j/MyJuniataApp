package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityFamilyResourceBinding

class FamilyResourceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFamilyResourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFamilyResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:18146433205")
                )
            )
        }

        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:info@juniata.edu"))
            )
        }

        // Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "geo:0,0?q=Sill+Business+Center+419+14th+St+Huntingdon+PA+16652"
                    )
                )
            )
        }

        // Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://dev.juniata.edu/parents/index.php")
                )
            )
        }
    }
}
