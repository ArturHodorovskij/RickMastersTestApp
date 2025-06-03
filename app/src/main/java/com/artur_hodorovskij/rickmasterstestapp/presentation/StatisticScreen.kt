package com.artur_hodorovskij.rickmasterstestapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.TopAppBar
import com.artur_hodorovskij.rickmasterstestapp.presentation.design.Visitors

@Composable
fun StatisticScreen() {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        TopAppBar()
        Visitors()

    }
}


@Preview(showBackground = true)
@Composable
fun StatisticScreenPreview() {
    StatisticScreen()
}