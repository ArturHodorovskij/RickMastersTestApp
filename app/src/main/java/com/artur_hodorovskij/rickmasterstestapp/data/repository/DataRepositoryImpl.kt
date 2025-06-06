package com.artur_hodorovskij.rickmasterstestapp.data.repository

import com.artur_hodorovskij.rickmasterstestapp.data.network.GetDataFromApi
import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic
import com.artur_hodorovskij.rickmasterstestapp.domain.models.StatisticList
import com.artur_hodorovskij.rickmasterstestapp.domain.models.User
import com.artur_hodorovskij.rickmasterstestapp.domain.models.UserFiles
import com.artur_hodorovskij.rickmasterstestapp.domain.models.UserList
import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository

class DataRepositoryImpl(private val getDataFromApi: GetDataFromApi) : DataRepository {
    override suspend fun getStatistic(): StatisticList {
        val statisticValue = getDataFromApi.getStatisticData()
        return statisticValue.let {
            StatisticList(
                statistics = it.statistics.map { it ->
                    Statistic(
                        userId = it.userId,
                        type = it.type,
                        dates = it.dates
                    )
                }
            )
        }
    }

    override suspend fun getUser(): UserList {
        val userValue = getDataFromApi.getUserData()
        return userValue.let {
            UserList(users = it.users.map { it ->
                User(
                    id = it.id,
                    sex = it.sex,
                    userName = it.username,
                    isOnline = it.isOnline,
                    age = it.age,
                    files = it.files.map { it ->
                        UserFiles(
                            id = it.id,
                            url = it.url
                        )
                    })
            }
            )
        }
    }
}