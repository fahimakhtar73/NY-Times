package com.applligent.nytimes.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applligent.nytimes.R
import com.applligent.nytimes.data.model.ArticlesData
import com.applligent.nytimes.ui.main.view.DetailArticleActivity
import kotlinx.android.synthetic.main.item_layout.view.*

class ArticleAdapter(
    private val articlesDataList: ArrayList<ArticlesData>,
    private val context: Context) : RecyclerView.Adapter<ArticleAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: ArticlesData) {
            itemView.textViewTitle.text = article.title
            itemView.textViewDescription.text = article.abstract
            itemView.textViewDate.text = article.publisheddate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = articlesDataList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(articlesDataList[position])
        holder.itemView.cardView.setOnClickListener {
            val intent = Intent(context, DetailArticleActivity::class.java)
            intent.putExtra("title",articlesDataList[position].title)
            intent.putExtra("date",articlesDataList[position].updated)
            intent.putExtra("author",articlesDataList[position].byline)
            intent.putExtra("description",articlesDataList[position].abstract)
            context.startActivity(intent)
        }
    }


    fun addData(list: List<ArticlesData>) {
        articlesDataList.addAll(list)
    }

}
