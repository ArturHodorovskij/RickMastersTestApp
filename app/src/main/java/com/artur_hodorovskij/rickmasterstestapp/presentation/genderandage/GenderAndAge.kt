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
import com.artur_hodorovskij.rickmasterstestapp.data.models.Period
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.PeriodButton

@Composable
fun GenderAndAge() {
    var selectedPeriod by remember { mutableStateOf(Period.TODAY) }
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
        PeriodButton(
            text = "По дням",
            isSelected = selectedPeriod == Period.TODAY,
            onClick = { selectedPeriod = Period.TODAY }
        )
        PeriodButton(
            text = "По неделям",
            isSelected = selectedPeriod == Period.WEEKLY,
            onClick = { selectedPeriod = Period.WEEKLY }
        )
        PeriodButton(
            text = "По месяцам",
            isSelected = selectedPeriod == Period.MONTHLY,
            onClick = { selectedPeriod = Period.MONTHLY }
        )
        PeriodButton(
            text = "По месяцам",
            isSelected = selectedPeriod == Period.ALL_TIME,
            onClick = { selectedPeriod = Period.ALL_TIME }
        )
    }
}
