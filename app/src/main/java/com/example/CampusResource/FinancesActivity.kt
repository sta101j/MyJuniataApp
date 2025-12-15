package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityFinancesBinding

class FinancesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinancesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinancesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🎓 Tuition & Financial Aid
        binding.blockTuition.setOnClickListener {
            openFinanceDetail(
                title = "Tuition & Financial Aid",
                target = FinanceDetailTuitionActivity::class.java
            )
        }

        // 💳 Bursar
        binding.blockBursar.setOnClickListener {
            openFinanceDetail(
                title = "Bursar",
                target = FinanceDetailBursar::class.java
            )
        }

        // 🎓 Scholarships & Aid
        binding.blockScholarships.setOnClickListener {
            openFinanceDetail(
                title = "Scholarships & Aid",
                target = FinanceDetailScholarships::class.java
            )
        }
    }

    // ✅ Reusable navigator
    private fun openFinanceDetail(
        title: String,
        target: Class<*>
    ) {
        val intent = Intent(this, target)
        intent.putExtra("title", title)
        startActivity(intent)
    }
}
