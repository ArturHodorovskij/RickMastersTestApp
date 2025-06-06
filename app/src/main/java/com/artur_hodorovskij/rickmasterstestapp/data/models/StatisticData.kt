package com.artur_hodorovskij.rickmasterstestapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatisticData(
    @SerialName("user_id") val userId: Int,
    @SerialName("type") val type: String,
    @SerialName("dates") val dates: List<Int>
)
