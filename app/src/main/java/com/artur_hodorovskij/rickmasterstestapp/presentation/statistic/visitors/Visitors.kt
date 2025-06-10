package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.visitors

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
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.StatisticScreenState
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.StatisticViewModel
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.design.StatisticCard


@Composable
fun Visitors(content: StatisticScreenState.Content, viewModel: StatisticViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Посетители",
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp
        )

        StatisticCard(
            lineImage = painterResource(R.drawable.growth_line),
            arrowImage = painterResource(R.drawable.arrow_up),
            quantity = "1356",
            title = "Количество посетителей в этом месяце выросло"
        )

        VisitContent(content = content,viewModel = viewModel)
    }
}
