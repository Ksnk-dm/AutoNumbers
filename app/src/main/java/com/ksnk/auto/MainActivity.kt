package com.ksnk.auto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.GsonBuilder
import com.ksnk.auto.entity.Auto

class MainActivity : AppCompatActivity() {
    private var buttonSearch: Button? = null
    var json = "{\n" +
            "  \"digits\": \"KA0007XB\",\n" +
            "  \"vin\": \"WBA7########57838\", // VIN-код сейчас доступен только для регистраций 2021 года\n" +
            "  \"region\": {\n" +
            "    \"name\": \"г. Киев\",\n" +
            "    \"name_ua\": \"м. Київ\",\n" +
            "    \"slug\": \"kyiv\",\n" +
            "    \"old_code\": \"AA\",\n" +
            "    \"new_code\": \"KA\"\n" +
            "  },\n" +
            "  \"vendor\": \"BMW\",\n" +
            "  \"model\": \"M760LI\",\n" +
            "  \"model_year\": 2021,\n" +
            "  \"photo_url\": \"https://baza-gai.com.ua/catalog-images/bmw/7er/VI (G11-G12) Рестайлинг/image.jpg\",\n" +
            "  \"is_stolen\": false,\n" +
            "  \"operations\": [\n" +
            "    {\n" +
            "      \"is_last\": true,\n" +
            "      \"catalog_model_title\": \"LS\", // при подписке от 10 тыс. запросов\n" +
            "      \"catalog_model_slug\": \"ls\", // при подписке от 10 тыс. запросов\n" +
            "      \"body\": { // при подписке от 10 тыс. запросов\n" +
            "        \"id\": 4,\n" +
            "        \"ua\": \"СЕДАН\",\n" +
            "        \"ru\": \"Седан\"\n" +
            "      },\n" +
            "      \"purpose\": { // при подписке от 10 тыс. запросов\n" +
            "          \"id\": 1,\n" +
            "          \"ua\": \"ЗАГАЛЬНИЙ\",\n" +
            "          \"ru\": \"Общий\"\n" +
            "      },\n" +
            "      \"registered_at\": \"03.04.2021\",\n" +
            "      \"model_year\": 2021,\n" +
            "      \"vendor\": \"BMW\",\n" +
            "      \"vendor_slug\": \"bmw\",\n" +
            "      \"model\": \"M760LI\",\n" +
            "      \"operation\": {\n" +
            "        \"ru\": \"Первичная регистрация нового ТС, автосалон, ввезено из-за границы\",\n" +
            "        \"ua\": \"Первинна реєстрація нового тз придбаного в торгівельній організації, який ввезено з-за кордону\"\n" +
            "      },\n" +
            "      \"department\": \"ТСЦ 8047\",\n" +
            "      \"color\": {\n" +
            "        \"slug\": \"gray\",\n" +
            "        \"ru\": \"Серый\",\n" +
            "        \"ua\": \"Сірий\"\n" +
            "      },\n" +
            "      \"is_registered_to_company\": false,\n" +
            "      \"address\": \"м.Київ, Деснянський\",\n" +
            "      \"koatuu\": 8036400000,\n" +
            "      \"displacement\": 6592,\n" +
            "      \"kind\": {\n" +
            "        \"id\": 1,\n" +
            "        \"ru\": \"Легковой\",\n" +
            "        \"ua\": \"Легковий\",\n" +
            "        \"slug\": \"car\"\n" +
            "      },\n" +
            "      \"operation_group\": {\n" +
            "        \"id\": 1,\n" +
            "        \"ru\": \"Первичная регистрация\",\n" +
            "        \"ua\": \"Первинна реєстрація\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gson = GsonBuilder().create()
        var auto: Auto? = gson.fromJson(json, Auto::class.java)
        Log.d("auto", auto?.getModel().toString())
        buttonSearch = findViewById(R.id.searchButton)
        buttonSearch?.setOnClickListener {
            var intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("auto", auto)
            startActivity(intent)
        }
    }
}