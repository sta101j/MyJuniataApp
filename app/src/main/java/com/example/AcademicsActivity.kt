package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityAcademicsBinding

class AcademicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAcademicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAcademicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }



        binding.blockAcademicResources.setOnClickListener {
            startActivity(Intent(this, AcademicResourcesActivity::class.java))
        }


        binding.blockWritingCenter.setOnClickListener {
            startActivity(Intent(this, WritingCenterActivity::class.java))
        }


        binding.blockProvost.setOnClickListener {
            startActivity(
                Intent(this, ProvostActivity::class.java)
            )
        }

        binding.blockCollegeAdvising.setOnClickListener {
            startActivity(Intent(this, CollegeAdvisingActivity::class.java))
        }

        binding.blockPrograms.setOnClickListener {
            startActivity(Intent(this, ProgramsActivity::class.java))
        }

    }
}
