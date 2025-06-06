package com.artur_hodorovskij.rickmasterstestapp.data.network

import com.artur_hodorovskij.rickmasterstestapp.data.models.StatisticResponse
import com.artur_hodorovskij.rickmasterstestapp.data.models.UserResponse

interface GetDataFromApi {
    suspend fun getUserData(): UserResponse
    suspend fun getStatisticData(): StatisticResponse
}

