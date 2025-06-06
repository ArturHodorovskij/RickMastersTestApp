package com.artur_hodorovskij.rickmasterstestapp.data.network

import com.artur_hodorovskij.rickmasterstestapp.data.models.StatisticResponse
import com.artur_hodorovskij.rickmasterstestapp.data.models.UserResponse

class GetDataFromApiImpl : GetDataFromApi {

    override suspend fun getStatisticData(): StatisticResponse = getStatistics()

    override suspend fun getUserData(): UserResponse = getUsers()

}
