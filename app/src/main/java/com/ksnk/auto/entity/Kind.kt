package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Kind : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("ru")
    @Expose
    var ru: String? = null

    @SerializedName("ua")
    @Expose
    var ua: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    override fun toString(): String {
        return "Kind(id=$id, ru=$ru, ua=$ua, slug=$slug)"
    }

}