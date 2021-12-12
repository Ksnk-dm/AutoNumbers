package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Auto:Serializable {
    @SerializedName("digits")
    @Expose
    private var digits: String? = null

    @SerializedName("vin")
    @Expose
    private var vin: String? = null

    @SerializedName("region")
    @Expose
    private var region: Region? = null

    @SerializedName("vendor")
    @Expose
    private var vendor: String? = null

    @SerializedName("model")
    @Expose
    private var model: String? = null

    @SerializedName("model_year")
    @Expose
    private var modelYear: Int? = null

    @SerializedName("photo_url")
    @Expose
    private var photoUrl: String? = null

    @SerializedName("is_stolen")
    @Expose
    private var isStolen: Boolean? = null

    @SerializedName("operations")
    @Expose
    private var operations: List<Operation?>? = null

    fun getDigits(): String? {
        return digits
    }

    fun setDigits(digits: String?) {
        this.digits = digits
    }

    fun getVin(): String? {
        return vin
    }

    fun setVin(vin: String?) {
        this.vin = vin
    }

    fun getRegion(): Region? {
        return region
    }

    fun setRegion(region: Region?) {
        this.region = region
    }

    fun getVendor(): String? {
        return vendor
    }

    fun setVendor(vendor: String?) {
        this.vendor = vendor
    }

    fun getModel(): String? {
        return model
    }

    fun setModel(model: String?) {
        this.model = model
    }

    fun getModelYear(): Int? {
        return modelYear
    }

    fun setModelYear(modelYear: Int?) {
        this.modelYear = modelYear
    }

    fun getPhotoUrl(): String? {
        return photoUrl
    }

    fun setPhotoUrl(photoUrl: String?) {
        this.photoUrl = photoUrl
    }

    fun getIsStolen(): Boolean? {
        return isStolen
    }

    fun setIsStolen(isStolen: Boolean?) {
        this.isStolen = isStolen
    }

    fun getOperations(): List<Operation?>? {
        return operations
    }

    fun setOperations(operations: List<Operation?>?) {
        this.operations = operations
    }

    override fun toString(): String {
        return "Auto(digits=$digits, vin=$vin, region=$region, vendor=$vendor, model=$model, modelYear=$modelYear, photoUrl=$photoUrl, isStolen=$isStolen, operations=$operations)"
    }

}