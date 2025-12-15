package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityStudentServicesBinding

class StudentServicesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStudentServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // Coaching (for now just placeholder)
        binding.blockCoaching.setOnClickListener {
            startActivity(Intent(this, CoachingDetailActivity::class.java))
        }



        binding.blockTutoring.setOnClickListener {
            startActivity(Intent(this, TutoringDetailActivity::class.java))
        }

    }
}
