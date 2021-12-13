package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class OperationGroup : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("ru")
    @Expose
    var ru: String? = null

    @SerializedName("ua")
    @Expose
    var ua: String? = null

    override fun toString(): String {
        return "OperationGroup(id=$id, ru=$ru, ua=$ua)"
    }

}