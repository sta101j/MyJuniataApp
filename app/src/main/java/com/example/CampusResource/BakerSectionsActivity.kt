package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.CampusResource.databinding.ActivityBakerSectionsBinding

class BakerSectionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBakerSectionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBakerSectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔙 Back
        binding.btnBack.setOnClickListener { finish() }

        // 🍽️ Spoon & Fork
        binding.sectionSpoonFork.setOnClickListener {
            val intent = Intent(this, SpoonForkActivity::class.java).apply {
                putExtra("name", "Spoon & Fork")
                putExtra("address", "Juniata College Campus")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra("imageRes", R.drawable.baker_eagle)
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
            }
            startActivity(intent)
        }

        // ☕ V2 Café
        binding.sectionV2Cafe.setOnClickListener {
            val intent = Intent(this, V2CafeActivity::class.java).apply {
                putExtra("name", "V2 Café")
                putExtra("address", "Baker Refectory – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra("imageRes", R.drawable.baker_eagle)
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
            }
            startActivity(intent)
        }

        binding.sectionCleanPlate.setOnClickListener {
            val intent = Intent(this, CleanPlateCafeActivity::class.java).apply {
                putExtra("name", "Clean Plate")
                putExtra("address", "Baker Refectory – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle) // update if different
            }
            startActivity(intent)
        }

        binding.sectionGrill.setOnClickListener {
            val intent = Intent(this, GrillActivity::class.java).apply {
                putExtra("name", "Grill")
                putExtra("address", "Baker Refectory – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle)
            }
            startActivity(intent)
        }
        binding.sectionSaladBar.setOnClickListener {
            val intent = Intent(this, SaladBarActivity::class.java).apply {
                putExtra("name", "Salad Bar")
                putExtra("address", "Baker Refectory – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle)
            }
            startActivity(intent)
        }

        binding.sectionOven.setOnClickListener {
            val intent = Intent(this, OvenCafeActivity::class.java).apply {
                putExtra("name", "Oven")
                putExtra("address", "Baker Refectory – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle)
            }
            startActivity(intent)
        }

        binding.sectionDeli.setOnClickListener {
            val intent = Intent(this, CafeDeliActivity::class.java).apply {
                putExtra("name", "CCafe – Deli")
                putExtra("address", "Campus Café – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle) // swap if you add deli-specific image
            }
            startActivity(intent)
        }

        binding.sectionBravo.setOnClickListener {
            val intent = Intent(this, BravoCafeActivity::class.java).apply {
                putExtra("name", "CCafe – Deli")
                putExtra("address", "Campus Café – Juniata College")
                putExtra("phone", "814-641-3000")
                putExtra("email", "dining@juniata.edu")
                putExtra(
                    "website",
                    "https://dev.juniata.edu/campus-life/dining.php"
                )
                putExtra("imageRes", R.drawable.baker_eagle)
            }
            startActivity(intent)
        }





    }
}
