package com.ksnk.auto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var buttonSearch: ImageButton? = null
    private var buttonCalc: ImageButton? = null
    private var buttonInform: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        buttonCalc = findViewById(R.id.calcImageButton)
        buttonInform = findViewById(R.id.informImageButton)
        buttonSearch = findViewById(R.id.searchImageButton)
        buttonInform?.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.develop), Toast.LENGTH_SHORT).show()
        }
        buttonCalc?.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.develop), Toast.LENGTH_SHORT).show()
        }
        buttonSearch?.setOnClickListener {
            var intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }
    }
}