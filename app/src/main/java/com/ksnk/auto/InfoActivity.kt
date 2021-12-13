package com.ksnk.auto

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.gson.GsonBuilder
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
    private var infoLinearLayout: LinearLayout? = null
    private var searhLinearLayout: LinearLayout? = null
    private var regOrg: String? = null
    private var searchEditText: EditText? = null
    private var buttonSearch: Button? = null


    private fun init() {
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
        infoLinearLayout = findViewById(R.id.info_linear_layout)
        searhLinearLayout = findViewById(R.id.search_linear_layout)
        searchEditText = findViewById(R.id.searchNumberEditText)
        buttonSearch = findViewById(R.id.buttonSearch)
        buttonSearch?.setOnClickListener {
            searchGet(searchEditText?.text.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        // fetchJson()
        init()
        setSupportActionBar(toolbar);

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        imageViewAuto?.setImageResource(R.drawable.searchinfo)
        supportActionBar?.title = "Поиск по гос номеру"
        //  setParams()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun setParamsSearch(auto: Auto) {
        val autoObj: Auto = auto//intent.getSerializableExtra("auto") as Auto
        supportActionBar?.title = autoObj.getDigits()
        searhLinearLayout?.visibility = VISIBLE
        infoLinearLayout?.visibility = GONE
        if (autoObj.getPhotoUrl().isNullOrEmpty()) {
            imageViewAuto?.setImageResource(R.drawable.ic_placeholder)
        } else {
            Picasso.get()
                .load(autoObj.getPhotoUrl())
                .error(R.drawable.bg_gradient)
                .fit()
                .centerCrop()
                .into(imageViewAuto)
        }


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
        // val auto: Auto = intent.getSerializableExtra("auto") as Auto
//        supportActionBar?.title = auto.getDigits();

//        Picasso.get()
//            .load(auto.getPhotoUrl())
//            .error(R.drawable.bg_gradient)
//            .fit()
//            .centerCrop()
//            .into(imageViewAuto);
//
//        digitsTextView?.text = auto.getDigits()
//        vinCode?.text = auto.getVin()
//        modelHomeTextView?.text = auto.getVendor() + " " + auto.getModel()
//        regionTextView?.text = auto.getRegion()?.getName()
//        vendorTextView?.text = auto.getVendor()
//        modelTextView?.text = auto.getModel()
//        yearTextViewTextView?.text = auto.getModelYear().toString()
//        classAutoTextView?.text = auto.getOperations()?.get(0)?.getKind()?.getRu()
//        dateRegisterTextView?.text = auto.getOperations()?.get(0)?.getRegisteredAt()
//        informRegisterTextView?.text = auto.getOperations()?.get(0)?.getOperation()?.getRu()
//        orgTextView?.text = auto.getOperations()?.get(0)?.getDepartment()
//        colorTextView?.text = auto.getOperations()?.get(0)?.getColor()?.getRu()
//        regCompanyTextView?.text = regOrg
    }

    private fun searchGet(number: String) {
        var mainHandler = Handler(this@InfoActivity.mainLooper)
        val url = "https://baza-gai.com.ua/nomer/$number"

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
                    val gson = GsonBuilder().create()
                    var auto: Auto? = gson.fromJson(body, Auto::class.java)
                    setParamsSearch(auto!!)
                    Log.d("search text get", auto.toString())
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
