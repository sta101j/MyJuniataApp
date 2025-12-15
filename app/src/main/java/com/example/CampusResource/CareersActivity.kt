package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCareersBinding

class CareersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCareersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCareersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // POE & Career Exploration
        binding.blockPoeCareer.setOnClickListener {
            openDetail("POE & Career Exploration")
        }

        // Internships
        binding.blockInternships.setOnClickListener {
            openDetail("Internships")
       }

       // Job Search & Graduate School
       binding.blockJobSearch.setOnClickListener {
           openDetail("Job Search & Graduate School")
       }

        // Campus Employment
        binding.blockCampusEmployment.setOnClickListener {
            openDetail("Campus Employment")
        }
    }

    private fun openDetail(title: String) {
        val intent = Intent(this, CareerDetailActivity::class.java)
        intent.putExtra("title", title)
        startActivity(intent)
    }
}
