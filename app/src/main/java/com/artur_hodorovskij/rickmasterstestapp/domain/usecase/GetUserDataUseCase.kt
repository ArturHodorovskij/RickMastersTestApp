package com.artur_hodorovskij.rickmasterstestapp.domain.usecase

import com.artur_hodorovskij.rickmasterstestapp.domain.network.DataRepository
import com.artur_hodorovskij.rickmasterstestapp.domain.models.UserList

class GetUserDataUseCase(private val dataRepository: DataRepository) {

    suspend fun execute(): UserList =
        dataRepository.getUser()
}
