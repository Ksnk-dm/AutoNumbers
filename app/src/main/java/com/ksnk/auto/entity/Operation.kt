package com.ksnk.auto.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Operation: Serializable {
    @SerializedName("is_last")
    @Expose
    private var isLast: Boolean? = null

    @SerializedName("catalog_model_title")
    @Expose
    private var catalogModelTitle: String? = null

    @SerializedName("catalog_model_slug")
    @Expose
    private var catalogModelSlug: String? = null

    @SerializedName("body")
    @Expose
    private var body: Body? = null

    @SerializedName("purpose")
    @Expose
    private var purpose: Purpose? = null

    @SerializedName("registered_at")
    @Expose
    private var registeredAt: String? = null

    @SerializedName("model_year")
    @Expose
    private var modelYear: Int? = null

    @SerializedName("vendor")
    @Expose
    private var vendor: String? = null

    @SerializedName("vendor_slug")
    @Expose
    private var vendorSlug: String? = null

    @SerializedName("model")
    @Expose
    private var model: String? = null

    @SerializedName("operation")
    @Expose
    private var operation: Operation2? = null

    @SerializedName("department")
    @Expose
    private var department: String? = null

    @SerializedName("color")
    @Expose
    private var color: Color? = null

    @SerializedName("is_registered_to_company")
    @Expose
    private var isRegisteredToCompany: Boolean? = null

    @SerializedName("address")
    @Expose
    private var address: String? = null

    @SerializedName("koatuu")
    @Expose
    private var koatuu: Long? = null

    @SerializedName("displacement")
    @Expose
    private var displacement: Int? = null

    @SerializedName("kind")
    @Expose
    private var kind: Kind? = null

    @SerializedName("operation_group")
    @Expose
    private var operationGroup: OperationGroup? = null

    fun getIsLast(): Boolean? {
        return isLast
    }

    fun setIsLast(isLast: Boolean?) {
        this.isLast = isLast
    }

    fun getCatalogModelTitle(): String? {
        return catalogModelTitle
    }

    fun setCatalogModelTitle(catalogModelTitle: String?) {
        this.catalogModelTitle = catalogModelTitle
    }

    fun getCatalogModelSlug(): String? {
        return catalogModelSlug
    }

    fun setCatalogModelSlug(catalogModelSlug: String?) {
        this.catalogModelSlug = catalogModelSlug
    }

    fun getBody(): Body? {
        return body
    }

    fun setBody(body: Body?) {
        this.body = body
    }

    fun getPurpose(): Purpose? {
        return purpose
    }

    fun setPurpose(purpose: Purpose?) {
        this.purpose = purpose
    }

    fun getRegisteredAt(): String? {
        return registeredAt
    }

    fun setRegisteredAt(registeredAt: String?) {
        this.registeredAt = registeredAt
    }

    fun getModelYear(): Int? {
        return modelYear
    }

    fun setModelYear(modelYear: Int?) {
        this.modelYear = modelYear
    }

    fun getVendor(): String? {
        return vendor
    }

    fun setVendor(vendor: String?) {
        this.vendor = vendor
    }

    fun getVendorSlug(): String? {
        return vendorSlug
    }

    fun setVendorSlug(vendorSlug: String?) {
        this.vendorSlug = vendorSlug
    }

    fun getModel(): String? {
        return model
    }

    fun setModel(model: String?) {
        this.model = model
    }

    fun getOperation(): Operation2? {
        return operation
    }

    fun setOperation(operation: Operation2?) {
        this.operation = operation
    }

    fun getDepartment(): String? {
        return department
    }

    fun setDepartment(department: String?) {
        this.department = department
    }

    fun getColor(): Color? {
        return color
    }

    fun setColor(color: Color?) {
        this.color = color
    }

    fun getIsRegisteredToCompany(): Boolean? {
        return isRegisteredToCompany
    }

    fun setIsRegisteredToCompany(isRegisteredToCompany: Boolean?) {
        this.isRegisteredToCompany = isRegisteredToCompany
    }

    fun getAddress(): String? {
        return address
    }

    fun setAddress(address: String?) {
        this.address = address
    }

    fun getKoatuu(): Long? {
        return koatuu
    }

    fun setKoatuu(koatuu: Long?) {
        this.koatuu = koatuu
    }

    fun getDisplacement(): Int? {
        return displacement
    }

    fun setDisplacement(displacement: Int?) {
        this.displacement = displacement
    }

    fun getKind(): Kind? {
        return kind
    }

    fun setKind(kind: Kind?) {
        this.kind = kind
    }

    fun getOperationGroup(): OperationGroup? {
        return operationGroup
    }

    fun setOperationGroup(operationGroup: OperationGroup?) {
        this.operationGroup = operationGroup
    }

    override fun toString(): String {
        return "Operation(isLast=$isLast, catalogModelTitle=$catalogModelTitle, catalogModelSlug=$catalogModelSlug, body=$body, purpose=$purpose, registeredAt=$registeredAt, modelYear=$modelYear, vendor=$vendor, vendorSlug=$vendorSlug, model=$model, operation=$operation, department=$department, color=$color, isRegisteredToCompany=$isRegisteredToCompany, address=$address, koatuu=$koatuu, displacement=$displacement, kind=$kind, operationGroup=$operationGroup)"
    }

}