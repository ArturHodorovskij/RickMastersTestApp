package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artur_hodorovskij.rickmasterstestapp.data.network.GetDataFromApiImpl
import com.artur_hodorovskij.rickmasterstestapp.data.repository.DataRepositoryImpl
import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic
import com.artur_hodorovskij.rickmasterstestapp.domain.usecase.GetStatisticDataUseCase
import com.artur_hodorovskij.rickmasterstestapp.domain.usecase.GetUserDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

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

    fun parseDate(dateInt: Int): LocalDate {
        val dateStr = dateInt.toString().padStart(8, '0')
        val day = dateStr.substring(0, 2).toInt()
        val month = dateStr.substring(2, 4).toInt()
        val year = dateStr.substring(4, 8).toInt()
        return LocalDate.of(year, month, day)
    }

    fun preparePoints(statistics: List<Statistic>): List<PointDateCount> {
        val viewsCount = mutableMapOf<LocalDate, Int>()

        for (visitType in statistics) {
            if (visitType.type == "view") {
                for (dateInt in visitType.dates) {
                    val date = parseDate(dateInt)
                    viewsCount[date] = viewsCount.getOrDefault(date, 0) + 1
                }
            }
        }

        val sorted = viewsCount.toSortedMap()
        val sortedList = sorted.toList()

        return sortedList.mapIndexed { index, entry ->
            PointDateCount(
                index.toFloat(),
                entry.second.toFloat(),
                entry.first
            )
        }
    }

    data class PointDateCount(val x: Float, val y: Float, val date: LocalDate)
}

