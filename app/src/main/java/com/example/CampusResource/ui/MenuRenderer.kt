package com.example.CampusResource.ui

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.CampusResource.R

object MenuRenderer {

    fun render(
        context: Context,
        container: LinearLayout,
        items: List<String>
    ) {
        container.removeAllViews()

        val inflater = LayoutInflater.from(context)

        items.forEach { item ->
            val tv = inflater
                .inflate(R.layout.item_menu_row, container, false) as TextView

            tv.text = "•  $item"

            container.addView(tv)
        }
    }
}
