package com.mevron.driver.retrofit
import com.applligent.nytimes.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET(Constants.API_KEY)
    fun getArticleList(): Call<Any?>

}

