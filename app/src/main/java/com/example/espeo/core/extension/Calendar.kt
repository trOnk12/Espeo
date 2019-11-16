package com.example.espeo.core.extension

import java.util.Calendar

fun Calendar.getCurrentYear():Int{
   return Calendar.getInstance().get(Calendar.YEAR)
}