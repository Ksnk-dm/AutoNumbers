package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Color : Serializable {
    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("ru")
    @Expose
    var ru: String? = null

    @SerializedName("ua")
    @Expose
    var ua: String? = null

    override fun toString(): String {
        return "Color(slug=$slug, ru=$ru, ua=$ua)"
    }

}