package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Kind: Serializable {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("ru")
    @Expose
    private var ru: String? = null

    @SerializedName("ua")
    @Expose
    private var ua: String? = null

    @SerializedName("slug")
    @Expose
    private var slug: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getRu(): String? {
        return ru
    }

    fun setRu(ru: String?) {
        this.ru = ru
    }

    fun getUa(): String? {
        return ua
    }

    fun setUa(ua: String?) {
        this.ua = ua
    }

    fun getSlug(): String? {
        return slug
    }

    fun setSlug(slug: String?) {
        this.slug = slug
    }

    override fun toString(): String {
        return "Kind(id=$id, ru=$ru, ua=$ua, slug=$slug)"
    }

}