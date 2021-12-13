package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Purpose : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("ua")
    @Expose
    var ua: String? = null

    @SerializedName("ru")
    @Expose
    var ru: String? = null


    override fun toString(): String {
        return "Purpose(id=$id, ua=$ua, ru=$ru)"
    }


}