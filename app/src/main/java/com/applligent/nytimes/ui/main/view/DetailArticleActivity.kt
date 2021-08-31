package com.applligent.nytimes.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.applligent.nytimes.R
import com.applligent.nytimes.utils.Constants
import com.applligent.nytimes.utils.Utility
import kotlinx.android.synthetic.main.activity_detail_article.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DetailArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)

        setupUI()
    }

    fun setupUI(){

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)

        getSupportActionBar()?.setTitle(getString(R.string.article_details))

        val bundle: Bundle? = intent.extras
        bundle.apply {
            //Intent with data
            val titleStr: String = bundle?.getString("title").toString()
            textViewTitle.text = titleStr

            val authorStr: String = bundle?.getString("author").toString()
            textViewAuthor.text = authorStr

            val dateStr: String = Utility.parseDateToddMMyyyy(bundle?.getString("date").toString()).toString()
            textViewDate.text = dateStr

            val descriptionStr: String = bundle?.getString("description").toString()
            textViewDescription.text = descriptionStr



        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }
}