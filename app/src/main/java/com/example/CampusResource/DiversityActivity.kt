package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityDiversityBinding

class DiversityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiversityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back
        binding.btnBack.setOnClickListener { finish() }

        // ✅ Campus Life → REAL Campus Life screen
        binding.blockCampusLife.setOnClickListener {
            startActivity(
                Intent(this, CampusLifeActivity::class.java)
            )
        }

        // International Students
        binding.blockInternational.setOnClickListener {
            startActivity(
                Intent(this, InternationalOfficeActivity::class.java)
            )
        }

        // Multicultural Affairs
        binding.blockMulticultural.setOnClickListener {
            startActivity(
                Intent(this, MulticulturalAffairsActivity::class.java)
            )
        }

        // Student Support
        binding.blockStudentSupport.setOnClickListener {
            startActivity(
                Intent(this, StudentSupportServicesActivity::class.java)
            )
        }


        // Family Resource Center
        binding.blockFamilyResource.setOnClickListener {
            startActivity(Intent(this, FamilyResourceActivity::class.java))
        }

        // Clubs & Organizations
        binding.blockClubs.setOnClickListener {
            startActivity(Intent(this, ClubsOrganizationsActivity::class.java))
        }

    }

    private fun openDetail(title: String) {
        val intent = Intent(this, DiversityDetailActivity::class.java)
        intent.putExtra("title", title)
        startActivity(intent)
    }
}
