package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import com.artur_hodorovskij.rickmasterstestapp.domain.models.Statistic
import com.artur_hodorovskij.rickmasterstestapp.domain.models.User

sealed class StatisticScreenState {
    data object Initial : StatisticScreenState()
    data object Loading : StatisticScreenState()
    data class Content(val user: User, val statistic: Statistic) : StatisticScreenState()
    data class Error(val errorMessage: String) : StatisticScreenState()
}