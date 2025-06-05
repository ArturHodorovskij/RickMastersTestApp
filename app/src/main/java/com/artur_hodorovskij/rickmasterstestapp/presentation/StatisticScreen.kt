package com.artur_hodorovskij.rickmasterstestapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.TopAppBar
import com.artur_hodorovskij.rickmasterstestapp.presentation.genderandage.GenderAndAge
import com.artur_hodorovskij.rickmasterstestapp.presentation.genderandage.TwoLineDonutChart
import com.artur_hodorovskij.rickmasterstestapp.presentation.topvisitor.TopVisitors
import com.artur_hodorovskij.rickmasterstestapp.presentation.visitors.VisitChart
import com.artur_hodorovskij.rickmasterstestapp.presentation.visitors.Visitors

@Composable
fun StatisticScreen(modifier:Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        TopAppBar()
        Visitors()
        VisitChart()
        TopVisitors()
        GenderAndAge()
        TwoLineDonutChart()
    }
}


@Preview(showBackground = true)
@Composable
fun StatisticScreenPreview() {
    StatisticScreen(modifier=Modifier)
}