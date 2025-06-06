package com.artur_hodorovskij.rickmasterstestapp.domain.network

import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic
import com.artur_hodorovskij.rickmasterstestapp.domain.models.User

interface DataRepository {
    suspend fun getUser(): User
    suspend fun getStatistic():Statistic
}