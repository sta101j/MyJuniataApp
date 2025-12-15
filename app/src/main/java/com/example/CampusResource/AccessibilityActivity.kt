package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityAccessibilityBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AccessibilityActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityAccessibilityBinding
    private lateinit var googleMap: GoogleMap

    private val goodHall = LatLng(40.50132, -78.01577) // Juniata Good Hall

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessibilityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // HEADER
        binding.tvHeader.text = "Accessibility Services"
        binding.btnBack.setOnClickListener { finish() }

        // INFO DATA
        val office = "Good Hall Room 218"
        val testing = "Good Hall Room 216"
        val email = "accessibility@juniata.edu"
        val phone = "814-641-5840"
        val website = "https://www.juniata.edu/student-accessibility-services/"

        binding.tvOffice.text = "Office: $office"
        binding.tvTestingCenter.text = "Testing Center: $testing"
        binding.tvEmail.text = email
        binding.tvPhone.text = phone

        // BUTTON ACTIONS
        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
        }

        binding.btnEmail.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")))
        }

        binding.btnWebsite.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(website)))
        }

        binding.btnDirections.setOnClickListener {
            val mapUri = Uri.parse("google.navigation:q=Good+Hall+Juniata+College")
            val intent = Intent(Intent.ACTION_VIEW, mapUri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

//        // MAP INIT
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.mapFragment) as SupportMapFragment
//        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap.addMarker(MarkerOptions().position(goodHall).title("Good Hall"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(goodHall, 17f))
    }
}
