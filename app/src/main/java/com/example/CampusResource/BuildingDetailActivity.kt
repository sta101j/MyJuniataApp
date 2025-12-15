package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityBuildingDetailBinding

class BuildingDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuildingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // GET DATA
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val lat = intent.getDoubleExtra("lat", 0.0)
        val lng = intent.getDoubleExtra("lng", 0.0)

        binding.tvName.text = name
        binding.tvAddress.text = address

        // BACK BUTTON
        binding.btnBack.setOnClickListener { finish() }

        // GOOGLE MAPS NAVIGATION
        binding.btnDirections.setOnClickListener {
            val uri = Uri.parse("geo:$lat,$lng?q=$lat,$lng($name)")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}
