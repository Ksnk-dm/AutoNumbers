package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Operation__1 : Serializable {
    @SerializedName("ru")
    @Expose
    private var ru: String? = null

    @SerializedName("ua")
    @Expose
    private var ua: String? = null

    fun getRu(): String? {
        return ru
    }

    fun setRu(ru: String?) {
        this.ru = ru
    }

    fun getUa(): String? {
        return ua
    }

    fun setUa(ua: String?) {
        this.ua = ua
    }

    override fun toString(): String {
        return "Operation__1(ru=$ru, ua=$ua)"
    }

}