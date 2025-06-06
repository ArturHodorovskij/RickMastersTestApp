package com.artur_hodorovskij.rickmasterstestapp.domain.models

data class User(
    val id: Int,
    val sex: String?,
    val userName: String?,
    val isOnline: Boolean,
    val age: Int,
    val files: List<UserFiles>?
)
