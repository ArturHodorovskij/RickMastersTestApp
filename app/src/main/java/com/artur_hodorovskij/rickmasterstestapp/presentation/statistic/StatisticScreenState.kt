package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import com.artur_hodorovskij.rickmasterstestapp.domain.models.StatisticList
import com.artur_hodorovskij.rickmasterstestapp.domain.models.UserList

sealed class StatisticScreenState {
    data object Initial : StatisticScreenState()
    data object Loading : StatisticScreenState()
    data class Content(val statistic: StatisticList,val user: UserList) : StatisticScreenState()
    data class Error(val errorMessage: String) : StatisticScreenState()
}