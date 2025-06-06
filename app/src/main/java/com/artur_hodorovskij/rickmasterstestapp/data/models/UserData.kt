package com.artur_hodorovskij.rickmasterstestapp.data.models

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id") val id: Int,
    @SerializedName("sex") val sex: String,
    @SerializedName("username") val userName: String,
    @SerializedName("isOnline") val isOnline: Boolean,
    @SerializedName("age") val age: Int,
    @SerializedName("files") val files: UserDataFiles
)
