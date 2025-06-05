package com.artur_hodorovskij.rickmasterstestapp.data.models

data class StatisticEntry(
    val user_id: Int,
    val type: String,
    val dates: List<Int>
)
