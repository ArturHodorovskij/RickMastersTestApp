package com.artur_hodorovskij.rickmasterstestapp.presentation.genderandage

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.data.models.GenderAndAgePeriod
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.PeriodButton

@Composable
fun GenderAndAge() {
    var selectedPeriod by remember { mutableStateOf(GenderAndAgePeriod.TODAY) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Пол и возраст",
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        GenderAndAgePeriod.entries.forEach { item ->
            PeriodButton(
                text = item.description,
                isSelected = selectedPeriod == item,
                onClick = { selectedPeriod = item }
            )
        }
    }
    when (selectedPeriod) {
        GenderAndAgePeriod.TODAY -> {
            GenderDonutChart()
            GenderAndAgeBarChart()
        }

        GenderAndAgePeriod.WEEKLY -> Unit
        GenderAndAgePeriod.MONTHLY -> Unit
        GenderAndAgePeriod.ALL_TIME -> Unit
    }
}
