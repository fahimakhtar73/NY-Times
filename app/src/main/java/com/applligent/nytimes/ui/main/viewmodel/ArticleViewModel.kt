package com.applligent.nytimes.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applligent.nytimes.data.model.Articles
import com.applligent.nytimes.data.repository.Repository
import com.google.gson.Gson
import org.json.JSONObject

class ArticleViewModel(val repository: Repository) : ViewModel() {

    public val articles = MutableLiveData<Articles>()

    fun getAllArticales() {
        repository.getAllArticales({ isSuccess, response ->
            try {
                    if (response.body() == null){
                        if (response.errorBody() != null) {
                            val errorObj = JSONObject(Gson().toJson(response.errorBody()))
                            Log.i("TAG", "updateTask: error $errorObj")
                        }
                    }else{
                        val res = Gson().toJson(response.body())
                        val mainObject = JSONObject(res)
                        var article = Gson().fromJson(mainObject.toString(),Articles::class.java)
                        articles.value = article
                    }
            }catch (e: Exception){
                Log.i("TAG", "updateTask: exception : "+e.message.toString())
            }
        })
    }
}