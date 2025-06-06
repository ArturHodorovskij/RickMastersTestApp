package com.artur_hodorovskij.rickmasterstestapp.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserDataFiles(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)
