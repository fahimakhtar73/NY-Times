package com.applligent.nytimes.ui.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.applligent.nytimes.data.repository.Repository
import com.applligent.nytimes.getOrAwaitValue
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArticleViewModelTest : TestCase(){

    private lateinit var viewModel: ArticleViewModel

    @get:Rule
    val instanTaskExecutorRolue = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()

        val repository = Repository()
        viewModel = ArticleViewModel(repository)
    }


    @Test
    fun testArticleViewModel(){

       viewModel.getAllArticales()
       val result = viewModel.articles.getOrAwaitValue().takeIf {
            it.results.size > 0
        }
        assertTrue(result != null)
    }

}