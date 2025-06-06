package com.artur_hodorovskij.rickmasterstestapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDataFiles(
    val id: Int,
    val url: String,
   val type: String
)
