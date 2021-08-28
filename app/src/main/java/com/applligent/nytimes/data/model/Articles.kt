package com.applligent.nytimes.data.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("copyright")
    val copyright: String = "",
    @SerializedName("results")
    val results: ArrayList<ArticlesData>,
)


data class ArticlesData(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("abstract")
    val abstract: String = "",
    @SerializedName("published_date")
    val publisheddate: String = "",
    @SerializedName("byline")
    val byline: String = "",
    @SerializedName("updated")
    val updated: String = "",
)