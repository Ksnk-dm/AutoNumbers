package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Auto : Serializable {
    @SerializedName("digits")
    @Expose
    var digits: String? = null

    @SerializedName("vin")
    @Expose
    var vin: String? = null

    @SerializedName("region")
    @Expose
    var region: Region? = null

    @SerializedName("vendor")
    @Expose
    var vendor: String? = null

    @SerializedName("model")
    @Expose
    var model: String? = null

    @SerializedName("model_year")
    @Expose
    var modelYear: Int? = null

    @SerializedName("photo_url")
    @Expose
    var photoUrl: String? = null

    @SerializedName("is_stolen")
    @Expose
    var isStolen: Boolean? = null

    @SerializedName("operations")
    @Expose
    var operations: List<Operation?>? = null

    override fun toString(): String {
        return "Auto(digits=$digits, vin=$vin, region=$region, vendor=$vendor, model=$model, modelYear=$modelYear, photoUrl=$photoUrl, isStolen=$isStolen, operations=$operations)"
    }

}