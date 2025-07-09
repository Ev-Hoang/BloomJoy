package com.hockotlin.bloomjoy4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class FlowerList2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flower_list_layout_2)

        val spinner: Spinner = findViewById(R.id.sortSpinner)
        val options = resources.getStringArray(R.array.sort_options)

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            R.id.spinnerText,
            options
        )
        spinner.adapter = adapter

        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val scrollToTopButton = findViewById<ImageButton>(R.id.scrollToTopButton)

        scrollToTopButton.setOnClickListener {
            scrollView.smoothScrollTo(0, 0)
        }
    }
}
