package com.ksnk.auto.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Color: Serializable {
    @SerializedName("slug")
    @Expose
    private var slug: String? = null

    @SerializedName("ru")
    @Expose
    private var ru: String? = null

    @SerializedName("ua")
    @Expose
    private var ua: String? = null

    fun getSlug(): String? {
        return slug
    }

    fun setSlug(slug: String?) {
        this.slug = slug
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

    override fun toString(): String {
        return "Color(slug=$slug, ru=$ru, ua=$ua)"
    }

}