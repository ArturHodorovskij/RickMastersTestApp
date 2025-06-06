package com.artur_hodorovskij.rickmasterstestapp.domain.models

data class Statistic(
    val userId: Int,
    val type: String?,
    val dates: List<String>?
)
