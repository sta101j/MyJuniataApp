package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityHealthBinding

class HealthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHealthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Kennedy Sports & Recreation Center
        binding.cardKennedy.setOnClickListener {
            startActivity(Intent(this, KennedyActivity::class.java))
        }


        binding.cardGlaeser.setOnClickListener {
            startActivity(Intent(this, GlaeserActivity::class.java))
        }

        binding.cardBroadTop.setOnClickListener {
            startActivity(Intent(this, BroadTopActivity::class.java))
        }

        binding.cardAthletics.setOnClickListener {
            startActivity(Intent(this, AthleticsActivity::class.java))
        }

    }
}
