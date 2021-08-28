package com.applligent.nytimes.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.applligent.nytimes.R
import com.applligent.nytimes.ui.main.viewmodel.ArticleViewModel
import com.applligent.nytimes.ui.base.ViewModelFactory
import com.applligent.nytimes.ui.main.adapter.ArticleAdapter
import kotlinx.android.synthetic.main.activity_main.*


class ArticleActivity : AppCompatActivity() {

    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArticleAdapter(arrayListOf(),this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
               0
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        articleViewModel.articles.observe(this, Observer {
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            adapter.addData(it.results)
            adapter.notifyDataSetChanged()
        })
    }


    private fun setupViewModel() {

        articleViewModel = ViewModelProviders.of(this, ViewModelFactory()).get(
            ArticleViewModel::class.java)

        articleViewModel.getAllArticales()

    }
}