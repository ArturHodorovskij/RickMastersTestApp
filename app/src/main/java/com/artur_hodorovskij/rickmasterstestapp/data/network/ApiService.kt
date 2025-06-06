package com.artur_hodorovskij.rickmasterstestapp.data.network

import com.artur_hodorovskij.rickmasterstestapp.data.models.StatisticData
import com.artur_hodorovskij.rickmasterstestapp.data.models.UserData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiService {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getUsers(): UserData {
        return client.get("http://test.rikmasters.ru/api/users/").body()
    }

    suspend fun getStatistics(): StatisticData {
        return client.get("http://test.rikmasters.ru/api/statistics/").body()
    }
}
