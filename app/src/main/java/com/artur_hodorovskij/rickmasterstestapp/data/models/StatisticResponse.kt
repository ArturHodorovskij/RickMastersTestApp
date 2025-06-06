package com.artur_hodorovskij.rickmasterstestapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatisticResponse(
    @SerialName("statistics") val statistics: List<StatisticData>
)
