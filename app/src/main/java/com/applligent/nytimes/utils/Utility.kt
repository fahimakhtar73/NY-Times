package com.applligent.nytimes.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utility {

    companion object {
        fun parseDateToddMMyyyy(time: String?): String? {
            val inputFormat = SimpleDateFormat(Constants.INPUT_DATE)
            val outputFormat = SimpleDateFormat(Constants.OUTPUT_DATE)
            var date: Date? = null
            var str: String? = null
            try {
                date = inputFormat.parse(time)
                str = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str
        }
    }
}