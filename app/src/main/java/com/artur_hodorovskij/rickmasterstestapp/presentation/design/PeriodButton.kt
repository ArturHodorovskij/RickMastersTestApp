package com.artur_hodorovskij.rickmasterstestapp.presentation.design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PeriodButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
            contentColor = if (isSelected or isSystemInDarkTheme()) Color.White else Color.Black
        ),
        border = BorderStroke(0.1.dp, Color.LightGray),
        modifier = Modifier.padding(8.dp)
    )
    {
        Text(text, fontSize = 15.sp)
    }
}