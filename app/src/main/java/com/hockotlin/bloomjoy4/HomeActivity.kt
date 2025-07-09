package com.hockotlin.bloomjoy4

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import android.widget.ImageButton
import android.widget.ScrollView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // file XML đã đúng

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navMenuButton = findViewById<ImageView>(R.id.navMenu)

        navMenuButton.setOnClickListener {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START)
            } else {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        val scrollView = findViewById<ScrollView>(R.id.scrollMiddle)
        val scrollToTopButton = findViewById<ImageButton>(R.id.scrollToTopButton)

        scrollToTopButton.setOnClickListener {
            scrollView.smoothScrollTo(0, 0)
        }
    }
}
