package com.artur_hodorovskij.rickmasterstestapp.presentation.spectators

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.R
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.StatisticCard

@Composable
fun Spectators() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Наблюдатели",
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp
        )
        StatisticCard(
            lineImage = painterResource(R.drawable.growth_line),
            arrowImage = painterResource(R.drawable.arrow_up),
            quantity = "1356",
            title = "Новые наблюдатели в этом месяце"
        )
        StatisticCard(
            lineImage = painterResource(R.drawable.falling_line),
            arrowImage = painterResource(R.drawable.arrow_down),
            quantity = "10",
            title = "Пользователей перестали за вами наблюдать"
        )
    }
}