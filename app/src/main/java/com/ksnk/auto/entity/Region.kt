package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Region : Serializable {
    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("name_ua")
    @Expose
    private var nameUa: String? = null

    @SerializedName("slug")
    @Expose
    private var slug: String? = null

    @SerializedName("old_code")
    @Expose
    private var oldCode: String? = null

    @SerializedName("new_code")
    @Expose
    private var newCode: String? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getNameUa(): String? {
        return nameUa
    }

    fun setNameUa(nameUa: String?) {
        this.nameUa = nameUa
    }

    fun getSlug(): String? {
        return slug
    }

    fun setSlug(slug: String?) {
        this.slug = slug
    }

    fun getOldCode(): String? {
        return oldCode
    }

    fun setOldCode(oldCode: String?) {
        this.oldCode = oldCode
    }

    fun getNewCode(): String? {
        return newCode
    }

    fun setNewCode(newCode: String?) {
        this.newCode = newCode
    }

    override fun toString(): String {
        return "Region(name=$name, nameUa=$nameUa, slug=$slug, oldCode=$oldCode, newCode=$newCode)"
    }


}