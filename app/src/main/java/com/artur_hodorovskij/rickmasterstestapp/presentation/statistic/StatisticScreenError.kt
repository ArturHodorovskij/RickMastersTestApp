package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticScreenError(
    errorMessage: StatisticScreenState.Error, refreshData: () -> Unit
) {
    BasicAlertDialog(onDismissRequest = {refreshData()}) {
        Text(
            text = "$errorMessage try again later",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}