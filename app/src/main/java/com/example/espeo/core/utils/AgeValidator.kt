package com.example.espeo.core.utils

import java.util.*

class AgeValidator {
    companion object {
        private val currentYear : Int
        get() = Calendar.getInstance().get(Calendar.YEAR)

        fun isAdult(majorityAge: Int, yearOfBirth: Int): Boolean {
             return (majorityAge >= (yearOfBirth - currentYear))
        }
    }
}