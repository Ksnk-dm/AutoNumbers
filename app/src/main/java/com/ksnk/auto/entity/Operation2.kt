package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Operation2 : Serializable {
    @SerializedName("ru")
    @Expose
    var ru: String? = null

    @SerializedName("ua")
    @Expose
    var ua: String? = null

    override fun toString(): String {
        return "Operation__1(ru=$ru, ua=$ua)"
    }

}