package com.example.espeo.core.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}