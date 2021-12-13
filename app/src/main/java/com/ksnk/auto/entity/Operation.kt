package com.ksnk.auto.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Operation : Serializable {
    @SerializedName("is_last")
    @Expose
    var isLast: Boolean? = null

    @SerializedName("catalog_model_title")
    @Expose
    var catalogModelTitle: String? = null

    @SerializedName("catalog_model_slug")
    @Expose
    var catalogModelSlug: String? = null

    @SerializedName("body")
    @Expose
    var body: Body? = null

    @SerializedName("purpose")
    @Expose
    var purpose: Purpose? = null

    @SerializedName("registered_at")
    @Expose
    var registeredAt: String? = null

    @SerializedName("model_year")
    @Expose
    var modelYear: Int? = null

    @SerializedName("vendor")
    @Expose
    var vendor: String? = null

    @SerializedName("vendor_slug")
    @Expose
    var vendorSlug: String? = null

    @SerializedName("model")
    @Expose
    var model: String? = null

    @SerializedName("operation")
    @Expose
    var operation: Operation2? = null

    @SerializedName("department")
    @Expose
    var department: String? = null

    @SerializedName("color")
    @Expose
    var color: Color? = null

    @SerializedName("is_registered_to_company")
    @Expose
    var isRegisteredToCompany: Boolean? = null

    @SerializedName("address")
    @Expose
    var address: String? = null

    @SerializedName("koatuu")
    @Expose
    var koatuu: Long? = null

    @SerializedName("displacement")
    @Expose
    var displacement: Int? = null

    @SerializedName("kind")
    @Expose
    var kind: Kind? = null

    @SerializedName("operation_group")
    @Expose
    var operationGroup: OperationGroup? = null

    override fun toString(): String {
        return "Operation(isLast=$isLast, catalogModelTitle=$catalogModelTitle, catalogModelSlug=$catalogModelSlug, body=$body, purpose=$purpose, registeredAt=$registeredAt, modelYear=$modelYear, vendor=$vendor, vendorSlug=$vendorSlug, model=$model, operation=$operation, department=$department, color=$color, isRegisteredToCompany=$isRegisteredToCompany, address=$address, koatuu=$koatuu, displacement=$displacement, kind=$kind, operationGroup=$operationGroup)"
    }

}