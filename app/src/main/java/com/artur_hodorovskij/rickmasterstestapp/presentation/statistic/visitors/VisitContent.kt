package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.visitors

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.artur_hodorovskij.rickmasterstestapp.data.models.VisitorsPeriod
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.design.PeriodButton

@Composable
fun VisitContent() {
    var selectedPeriod by remember { mutableStateOf(VisitorsPeriod.DAYS) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceAround,

            ) {
            VisitorsPeriod.entries.forEach { item ->
                PeriodButton(
                    text = item.description,
                    isSelected = selectedPeriod == item,
                    onClick = { selectedPeriod = item }
                )
            }
        }
    }
    when (selectedPeriod) {
        VisitorsPeriod.DAYS -> DailyDiagram()
        VisitorsPeriod.WEEKS -> Unit
        VisitorsPeriod.MONTHS -> Unit
    }

}
