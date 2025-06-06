package com.artur_hodorovskij.rickmasterstestapp.domain.usecase

import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository
import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic

class GetStatisticDataUseCase(private val dataRepository: DataRepository) {

    suspend fun execute(): Statistic =
        dataRepository.getStatistic()
}