package com.artur_hodorovskij.rickmasterstestapp.domain.usecase

import com.artur_hodorovskij.rickmasterstestapp.domain.models.StatisticList
import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository

class GetStatisticDataUseCase(private val dataRepository: DataRepository) {

    suspend fun execute(): StatisticList =
        dataRepository.getStatistic()
}