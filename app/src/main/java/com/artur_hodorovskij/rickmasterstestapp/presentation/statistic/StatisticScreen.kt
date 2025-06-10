package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.design.DownloadIndicator
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.genderandage.GenderAndAge
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.spectators.Spectators
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.topvisitor.TopVisitors
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.visitors.Visitors

@Composable
fun StatisticScreen(modifier: Modifier, viewModel: StatisticViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        when (state) {
            is StatisticScreenState.Initial -> Unit
            is StatisticScreenState.Loading -> DownloadIndicator()
            is StatisticScreenState.Content -> {
                Visitors(
                    content = (state as StatisticScreenState.Content), viewModel=viewModel
                )
                TopVisitors()
                GenderAndAge()
                Spectators()
            }

            is StatisticScreenState.Error -> StatisticScreenError(
                errorMessage = state as StatisticScreenState.Error,
                refreshData = viewModel::reloadData
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun StatisticScreenPreview() {
    StatisticScreen(modifier = Modifier)
}