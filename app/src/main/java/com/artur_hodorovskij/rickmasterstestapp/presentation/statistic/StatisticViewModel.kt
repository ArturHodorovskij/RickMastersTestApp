package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artur_hodorovskij.rickmasterstestapp.data.network.GetDataFromApiImpl
import com.artur_hodorovskij.rickmasterstestapp.data.repository.DataRepositoryImpl
import com.artur_hodorovskij.rickmasterstestapp.domain.usecase.GetStatisticDataUseCase
import com.artur_hodorovskij.rickmasterstestapp.domain.usecase.GetUserDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StatisticViewModel : ViewModel() {
    private var getDataFromApi = GetDataFromApiImpl()
    private var dataRepository =
        DataRepositoryImpl(getDataFromApi = getDataFromApi)
    private var getStatisticDataUseCase =
        GetStatisticDataUseCase(dataRepository = dataRepository)
    private var getUserDataUseCase =
        GetUserDataUseCase(dataRepository = dataRepository)


    private val _state = MutableStateFlow<StatisticScreenState>(StatisticScreenState.Initial)
    val state: StateFlow<StatisticScreenState> = _state

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = StatisticScreenState.Loading
        viewModelScope.launch {
            try {
                val getStatisticData = getStatisticDataUseCase.execute()
                val getUserData = getUserDataUseCase.execute()
                _state.value = StatisticScreenState.Content(getStatisticData, getUserData)
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    private fun handleError(errorMessage: String) {
        _state.value = StatisticScreenState.Error(errorMessage = errorMessage)
    }

    fun reloadData() {
        loadData()
    }
}

