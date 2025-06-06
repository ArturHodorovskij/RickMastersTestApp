package com.artur_hodorovskij.rickmasterstestapp.data.network

import com.artur_hodorovskij.rickmasterstestapp.data.models.StatisticData
import com.artur_hodorovskij.rickmasterstestapp.data.models.UserData

interface GetDataFromApi {
    suspend fun getUserData(): UserData
    suspend fun getStatisticData(): StatisticData
}

