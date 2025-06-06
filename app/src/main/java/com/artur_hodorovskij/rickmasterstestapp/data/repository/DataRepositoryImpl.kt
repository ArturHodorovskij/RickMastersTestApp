package com.artur_hodorovskij.rickmasterstestapp.data.repository

import com.artur_hodorovskij.rickmasterstestapp.data.network.GetDataFromApi
import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic
import com.artur_hodorovskij.rickmasterstestapp.domain.models.User
import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository

class DataRepositoryImpl(private val getDataFromApi: GetDataFromApi) : DataRepository {
    override suspend fun getStatistic(): Statistic {
        val statisticValue = getDataFromApi.getStatisticData()
        return statisticValue.let {
            Statistic(
                userId = it.userId,
                type = it.type,
                dates = it.dates
            )
        }
    }

    override suspend fun getUser(): User {
        val userValue = getDataFromApi.getUserData()
        return userValue.let {
            User(
                id = it.id,
                sex = it.sex,
                userName = it.userName,
                isOnline = it.isOnline,
                age = it.age,
                files = it.files
            )
        }
    }
}