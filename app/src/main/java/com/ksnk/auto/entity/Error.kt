package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Error {
    @SerializedName("error")
    @Expose
    var error: String? = null
}