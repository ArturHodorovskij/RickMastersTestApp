package com.artur_hodorovskij.rickmasterstestapp.presentation.visitors

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
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.PeriodButton

@Composable
fun VisitChart() {
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
            PeriodButton(
                text = "По дням",
                isSelected = selectedPeriod == VisitorsPeriod.DAYS,
                onClick = { selectedPeriod = VisitorsPeriod.DAYS }
            )

            PeriodButton(
                text = "По неделям",
                isSelected = selectedPeriod == VisitorsPeriod.WEEKS,
                onClick = { selectedPeriod = VisitorsPeriod.WEEKS }
            )

            PeriodButton(
                text = "По месяцам",
                isSelected = selectedPeriod == VisitorsPeriod.MONTHS,
                onClick = { selectedPeriod = VisitorsPeriod.MONTHS }
            )
        }
    }
    when (selectedPeriod) {
        VisitorsPeriod.DAYS ->   DailyChart()
        VisitorsPeriod.WEEKS -> Unit
        VisitorsPeriod.MONTHS -> Unit
    }

}
