package com.example.espeo.core.mapper

//Non-nullable
interface Mapper<I, O> {
    fun map(input: I): O
}
