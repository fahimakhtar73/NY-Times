package com.applligent.nytimes.data.repository

import com.mevron.driver.retrofit.ApiClient
import com.mevron.driver.retrofit.ApiInterface
import okhttp3.Response
import retrofit2.Call

class Repository() {

    fun getAllArticales(onResult: (isSuccess: Boolean, response: retrofit2.Response<Any?>) -> Unit) {
        val call = ApiClient().getClient()!!.create(ApiInterface::class.java)
        call.getArticleList().enqueue(object : retrofit2.Callback<Any?> {

            override fun onResponse(call: Call<Any?>, response: retrofit2.Response<Any?>) {
                onResult(true, response)
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
//                onResult(false, null)
            }
        })

    }
}