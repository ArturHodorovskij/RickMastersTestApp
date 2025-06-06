package com.artur_hodorovskij.rickmasterstestapp.domain.network

import com.artur_hodorovskij.rickmasterstestapp.domain.models.StatisticList
import com.artur_hodorovskij.rickmasterstestapp.domain.models.UserList

interface DataRepository {
    suspend fun getUser(): UserList
    suspend fun getStatistic():StatisticList
}