package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class OperationGroup: Serializable {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("ru")
    @Expose
    private var ru: String? = null

    @SerializedName("ua")
    @Expose
    private var ua: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

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
        return "OperationGroup(id=$id, ru=$ru, ua=$ua)"
    }

}