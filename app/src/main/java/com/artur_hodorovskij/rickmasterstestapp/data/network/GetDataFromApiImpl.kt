package com.artur_hodorovskij.rickmasterstestapp.data.network

import com.artur_hodorovskij.rickmasterstestapp.data.models.StatisticData
import com.artur_hodorovskij.rickmasterstestapp.data.models.UserData

class GetDataFromApiImpl : GetDataFromApi {

    override suspend fun getStatisticData(): StatisticData = ApiService().getStatistics()


    override suspend fun getUserData(): UserData = ApiService().getUsers()

}
