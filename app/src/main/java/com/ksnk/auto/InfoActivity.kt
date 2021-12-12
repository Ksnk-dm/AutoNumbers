package com.ksnk.auto

import android.annotation.SuppressLint
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
    private var modelHomeTextView: TextView? = null
    private var vinCode: TextView? = null
    private var toolbar: Toolbar? = null
    private var regionTextView: TextView? = null
    private var vendorTextView: TextView? = null
    private var modelTextView: TextView? = null
    private var yearTextViewTextView: TextView? = null
    private var classAutoTextView: TextView? = null
    private var dateRegisterTextView: TextView? = null
    private var informRegisterTextView: TextView? = null
    private var orgTextView: TextView? = null
    private var colorTextView: TextView? = null
    private var regCompanyTextView: TextView? = null

    private var regOrg: String? = null


    fun init() {
        toolbar = findViewById(R.id.toolbar)
        imageViewAuto = findViewById(R.id.imageViewAuto)
        digitsTextView = findViewById(R.id.digitsTextView)
        modelHomeTextView = findViewById(R.id.modelHome)
        regionTextView = findViewById(R.id.regionTextView)
        vendorTextView = findViewById(R.id.vendorTextView)
        modelTextView = findViewById(R.id.modelTextView)
        yearTextViewTextView = findViewById(R.id.yearTextView)
        classAutoTextView = findViewById(R.id.classAutoTextView)
        dateRegisterTextView = findViewById(R.id.dateRegisterTextView)
        informRegisterTextView = findViewById(R.id.informRegisterTextView)
        orgTextView = findViewById(R.id.orgTextView)
        colorTextView = findViewById(R.id.colorTextView)
        regCompanyTextView = findViewById(R.id.regCompanyTextView)
        vinCode = findViewById(R.id.vinTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        // fetchJson()
        init()
        setSupportActionBar(toolbar);
        setParams()
    }

    @SuppressLint("SetTextI18n")
    private fun setParams() {
        val autoObj: Auto = intent.getSerializableExtra("auto") as Auto
        supportActionBar?.title = autoObj.getDigits();

        Picasso.get()
            .load(autoObj.getPhotoUrl())
            .error(R.drawable.bg_gradient)
            .fit()
            .centerCrop()
            .into(imageViewAuto);

        digitsTextView?.text = autoObj.getDigits()
        vinCode?.text = autoObj.getVin()
        modelHomeTextView?.text = autoObj.getVendor() + " " + autoObj.getModel()
        regionTextView?.text = autoObj.getRegion()?.getName()
        vendorTextView?.text = autoObj.getVendor()
        modelTextView?.text = autoObj.getModel()
        yearTextViewTextView?.text = autoObj.getModelYear().toString()
        classAutoTextView?.text = autoObj.getOperations()?.get(0)?.getKind()?.getRu()
        dateRegisterTextView?.text = autoObj.getOperations()?.get(0)?.getRegisteredAt()
        informRegisterTextView?.text = autoObj.getOperations()?.get(0)?.getOperation()?.getRu()
        orgTextView?.text = autoObj.getOperations()?.get(0)?.getDepartment()
        colorTextView?.text = autoObj.getOperations()?.get(0)?.getColor()?.getRu()
        regOrg = if (autoObj?.getOperations()?.get(0)?.getIsRegisteredToCompany() == true) {
            "Да"
        } else {
            "Нет"
        }
        regCompanyTextView?.text = regOrg
        val auto: Auto = intent.getSerializableExtra("auto") as Auto
        supportActionBar?.title = auto.getDigits();

        Picasso.get()
            .load(auto.getPhotoUrl())
            .error(R.drawable.bg_gradient)
            .fit()
            .centerCrop()
            .into(imageViewAuto);

        digitsTextView?.text = auto.getDigits()
        vinCode?.text = auto.getVin()
        modelHomeTextView?.text = auto.getVendor() + " " + auto.getModel()
        regionTextView?.text = auto.getRegion()?.getName()
        vendorTextView?.text = auto.getVendor()
        modelTextView?.text = auto.getModel()
        yearTextViewTextView?.text = auto.getModelYear().toString()
        classAutoTextView?.text = auto.getOperations()?.get(0)?.getKind()?.getRu()
        dateRegisterTextView?.text = auto.getOperations()?.get(0)?.getRegisteredAt()
        informRegisterTextView?.text = auto.getOperations()?.get(0)?.getOperation()?.getRu()
        orgTextView?.text = auto.getOperations()?.get(0)?.getDepartment()
        colorTextView?.text = auto.getOperations()?.get(0)?.getColor()?.getRu()
        regCompanyTextView?.text = regOrg
    }

    fun fetchJson() {
        var mainHandler = Handler(this@InfoActivity.mainLooper)
        val url = "https://baza-gai.com.ua/nomer/KA0007XB"

        var request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("X-Api-Key", "token")
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