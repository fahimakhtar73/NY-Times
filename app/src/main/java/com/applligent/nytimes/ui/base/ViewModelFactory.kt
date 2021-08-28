package com.applligent.nytimes.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.applligent.nytimes.data.repository.Repository
import com.applligent.nytimes.ui.main.viewmodel.ArticleViewModel

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArticleViewModel(Repository()) as T
    }
}