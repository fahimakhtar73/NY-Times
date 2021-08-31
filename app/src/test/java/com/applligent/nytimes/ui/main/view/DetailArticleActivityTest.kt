package com.applligent.nytimes.ui.main.view

import androidx.test.platform.app.InstrumentationRegistry
import com.applligent.nytimes.utils.Utility
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DetailArticleActivityTest : TestCase() {

    @Test
    fun testParseDateToddMMyyyy() {
        val dateFormat = Utility.parseDateToddMMyyyy("2021-08-31 04:15:10")
        assertTrue(dateFormat != null)
    }
}