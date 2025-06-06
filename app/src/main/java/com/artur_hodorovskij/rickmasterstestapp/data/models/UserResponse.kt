package com.artur_hodorovskij.rickmasterstestapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
   val users: List<UserData>
)
