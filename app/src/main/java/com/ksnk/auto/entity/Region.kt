package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Region : Serializable {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("name_ua")
    @Expose
    var nameUa: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("old_code")
    @Expose
    var oldCode: String? = null

    @SerializedName("new_code")
    @Expose
    var newCode: String? = null


    override fun toString(): String {
        return "Region(name=$name, nameUa=$nameUa, slug=$slug, oldCode=$oldCode, newCode=$newCode)"
    }


}