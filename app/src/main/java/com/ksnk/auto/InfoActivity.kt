package com.ksnk.auto

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ksnk.auto.entity.Auto
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException

class InfoActivity : AppCompatActivity() {

    private var imageViewAuto: ImageView? = null
    private var digitsTextView: TextView? = null
    private var vinTextView: TextView? = null
    private var toolbar: Toolbar? = null
    private var regionTextView:TextView? = null
    private var vendorTextView:TextView?=null
    private var modelTextView:TextView?=null
    private var yearTextViewTextView:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        // fetchJson()
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);
        imageViewAuto = findViewById(R.id.imageViewAuto)
        digitsTextView = findViewById(R.id.digitsTextView)
        vinTextView = findViewById(R.id.vinTextView)
        regionTextView=findViewById(R.id.regionTextView)
        vendorTextView=findViewById(R.id.vendorTextView)
        modelTextView=findViewById(R.id.modelTextView)
        yearTextViewTextView=findViewById(R.id.yearTextView)

        val auto: Auto = intent.getSerializableExtra("auto") as Auto
        supportActionBar?.title = auto.getDigits();

        Picasso.get()
            .load(auto.getPhotoUrl())
            .error(R.drawable.bg_gradient)
            .into(imageViewAuto);

        digitsTextView?.text = auto.getDigits()
        vinTextView?.text = auto.getVin()
        regionTextView?.text= auto.getRegion()?.getName()
        vendorTextView?.text=auto.getVendor()
        modelTextView?.text=auto.getModel()
        yearTextViewTextView?.text=auto.getModelYear().toString()


    }

    fun fetchJson() {
        var mainHandler = Handler(this@InfoActivity.mainLooper)
        val url = "https://baza-gai.com.ua/nomer/KA0007XB"

        var request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("X-Api-Key", "5f167a8aafb5be1dbc20dcbc546240ee")
            .build();
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                mainHandler.post {
                    val body = response.body?.string()
                    println(body)
//                    val gson = GsonBuilder().create()
//                    var weather: Air? = gson.fromJson(body, Air::class.java)
//                    list?.add(weather!!)
//                    recyclerView?.adapter = AirRecyclerViewAdapter(list!!)
//                    textviewAqiMain?.setText(weather?.getData()?.get(0)?.getAqi().toString())
//                    println(weather)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("API execute failed")
            }
        })
    }
}