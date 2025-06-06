package com.artur_hodorovskij.rickmasterstestapp.data.models

import com.google.gson.annotations.SerializedName

data class StatisticData(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("dates") val dates: List<String>
)
