package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Purpose : Serializable {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("ua")
    @Expose
    private var ua: String? = null

    @SerializedName("ru")
    @Expose
    private var ru: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getUa(): String? {
        return ua
    }

    fun setUa(ua: String?) {
        this.ua = ua
    }

    fun getRu(): String? {
        return ru
    }

    fun setRu(ru: String?) {
        this.ru = ru
    }

    override fun toString(): String {
        return "Purpose(id=$id, ua=$ua, ru=$ru)"
    }


}