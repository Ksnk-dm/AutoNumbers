package com.ksnk.auto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CalcActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: NumberAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        adapter = NumberAdapter(this)
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Car"))
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Electro"))
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("other"))
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> { tab.text = "car"}
                1 -> { tab.text = "other"}
            }
            viewPager.setCurrentItem(tab.position, true)
        }.attach()


    }
}