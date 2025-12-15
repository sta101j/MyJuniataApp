package com.example.CampusResource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityDiversityBinding

class DiversityDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiversityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔹 Get title from intent
        val title = intent.getStringExtra("title") ?: "Diversity & Inclusion"

        // 🔹 Header
        binding.tvHeader.text = title

        // 🔙 Back button
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
