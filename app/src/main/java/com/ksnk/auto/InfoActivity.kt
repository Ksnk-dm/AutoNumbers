package com.ksnk.auto

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.gson.GsonBuilder
import com.ksnk.auto.entity.Auto
import com.ksnk.auto.entity.Error
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
    private var searchLinearLayout: LinearLayout? = null
    private var regOrg: String? = null
    private var searchEditText: EditText? = null
    private var buttonSearch: Button? = null
    private val token = "5f167a8aafb5be1dbc20dcbc546240ee"
    private val header = "application/json"


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
        searchLinearLayout = findViewById(R.id.search_linear_layout)
        searchEditText = findViewById(R.id.searchNumberEditText)
        buttonSearch = findViewById(R.id.buttonSearch)
        buttonSearch?.setOnClickListener {
            if (searchEditText?.text.isNullOrEmpty()) {
                Toast.makeText(applicationContext, R.string.set_number, Toast.LENGTH_LONG).show()
            } else {
                searchGet(searchEditText?.text.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        init()
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        imageViewAuto?.setImageResource(R.drawable.searchinfo)
        supportActionBar?.title = resources.getString(R.string.search_number)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun setParamsSearch(auto: Auto) {
        val autoObj: Auto = auto
        supportActionBar?.title = autoObj.digits
        searchLinearLayout?.visibility = VISIBLE
        infoLinearLayout?.visibility = GONE
        if (autoObj.photoUrl.isNullOrEmpty()) {
            imageViewAuto?.setImageResource(R.drawable.ic_placeholder)
        } else {
            Picasso.get()
                .load(autoObj.photoUrl)
                .error(R.drawable.bg_gradient)
                .fit()
                .centerCrop()
                .into(imageViewAuto)
        }

        digitsTextView?.text = autoObj.digits
        vinCode?.text = autoObj.vin
        modelHomeTextView?.text = autoObj.vendor + " " + autoObj.model
        regionTextView?.text = autoObj.region?.name
        vendorTextView?.text = autoObj.vendor
        modelTextView?.text = autoObj.model
        yearTextViewTextView?.text = autoObj.modelYear.toString()
        classAutoTextView?.text = autoObj.operations?.get(0)?.kind?.ru
        dateRegisterTextView?.text = autoObj.operations?.get(0)?.registeredAt
        informRegisterTextView?.text = autoObj.operations?.get(0)?.operation?.ru
        orgTextView?.text = autoObj.operations?.get(0)?.department
        colorTextView?.text = autoObj.operations?.get(0)?.color?.ru
        regOrg = if (autoObj?.operations?.get(0)?.isRegisteredToCompany == true) {
            resources.getString(R.string.yes)
        } else {
            resources.getString(R.string.no)
        }
        regCompanyTextView?.text = regOrg
    }

    private fun searchGet(number: String) {
        var mainHandler = Handler(this@InfoActivity.mainLooper)
        val url = "https://baza-gai.com.ua/nomer/$number"

        var request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        request = request.newBuilder()
            .addHeader("Accept", header)
            .addHeader("X-Api-Key", token)
            .build();
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                mainHandler.post {
                    val body = response.body?.string()
                    val gson = GsonBuilder().create()
                    var error: Error = gson.fromJson(body, Error::class.java)
                    if (error.error.isNullOrEmpty()) {
                        var auto: Auto? = gson.fromJson(body, Auto::class.java)
                        setParamsSearch(auto!!)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            resources.getString(R.string.not_found),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("API execute failed")
            }
        })
    }
}
