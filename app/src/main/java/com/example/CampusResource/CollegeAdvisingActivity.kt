package com.example.CampusResource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityCollegeAdvisingBinding

class CollegeAdvisingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollegeAdvisingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCollegeAdvisingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:8146413165")))
        }

        binding.btnEmail.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:registrar@juniata.edu")))
        }

        binding.btnDirections.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Founders+Hall+Juniata+College+Huntingdon+PA")
                )
            )
        }

        binding.btnWebsite.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.juniata.edu/registrar/contact.php")
                )
            )
        }


        binding.tvAdvisorForm.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://www.juniata.edu/registrar/media/Advisor%20Selection%20Form%20.pdf"
                    )
                )
            )
        }

    }
}
