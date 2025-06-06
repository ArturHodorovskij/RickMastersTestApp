package com.artur_hodorovskij.rickmasterstestapp.domain.usecase

import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository
import com.artur_hodorovskij.rickmasterstestapp.domain.models.User

class GetUserDataUseCase(private val dataRepository: DataRepository) {

    suspend fun execute(): User =
        dataRepository.getUser()
}
