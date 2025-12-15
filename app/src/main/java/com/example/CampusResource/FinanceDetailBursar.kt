package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityFinanceDetailBursarBinding

class FinanceDetailBursar : AppCompatActivity() {

    private lateinit var binding: ActivityFinanceDetailBursarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFinanceDetailBursarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🧭 Header
        binding.tvHeader.text = "Bursar"

        // 🖼️ Image
        binding.imgHeader.setImageResource(R.drawable.brumbaugh_bursar_finance)

        // 📞 Call
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413302"))
            )
        }

        // ✉️ Email
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:perowl@juniata.edu"))
            )
        }

        // 🧭 Directions
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=I.H.+Brumbaugh+Building+Juniata+College")
                )
            )
        }

        // 🌐 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/offices/bursar/bursar-contacts.php")
                )
            )
        }
    }
}
