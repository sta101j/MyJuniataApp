package com.example.CampusResource

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.CampusResource.databinding.ActivityBuildingListBinding

class BuildingListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuildingListBinding
    private lateinit var adapter: BuildingAdapter
    private lateinit var buildings: List<Building>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // BACK BUTTON
        binding.btnBack.setOnClickListener { finish() }

        // LOAD BUILDING DATA
        buildings = BuildingData.buildings   // <-- fixed

        // ADAPTER + CLICK ACTION
        adapter = BuildingAdapter(buildings) { selected ->
            val intent = Intent(this, BuildingDetailActivity::class.java)

            intent.putExtra("name", selected.name)
            intent.putExtra("code", selected.code)
            intent.putExtra("address", selected.address)
            intent.putExtra("lat", selected.lat)
            intent.putExtra("lng", selected.lng)

            startActivity(intent)
        }

        // SETUP LIST
        binding.recyclerBuildings.layoutManager = LinearLayoutManager(this)
        binding.recyclerBuildings.adapter = adapter

        // SEARCH BAR FILTER
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val q = s.toString().lowercase().trim()
                val filtered = buildings.filter {
                    it.name.lowercase().contains(q) ||
                            it.code.lowercase().contains(q)
                }
                adapter.filter(filtered)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
