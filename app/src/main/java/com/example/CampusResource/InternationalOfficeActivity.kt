package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityInternationalOfficeBinding

class InternationalOfficeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInternationalOfficeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInternationalOfficeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 📞 Call (primary office)
        binding.btnCall.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413182"))
            )
        }

        // ✉️ Email (general)
        binding.btnEmail.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:international@juniata.edu"))
            )
        }

        // 🧭 Directions (Oller Center, Juniata)
        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Oller+Center+Juniata+College+1700+Moore+Street+Huntingdon+PA+16652")
                )
            )
        }

        // 🌍 Website
        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/academics/departments/international/contacts.php")
                )
            )
        }
    }
}
