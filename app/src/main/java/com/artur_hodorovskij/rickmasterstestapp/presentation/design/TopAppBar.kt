package com.artur_hodorovskij.rickmasterstestapp.presentation.design

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
) {
    Row(
        modifier = Modifier
            .padding(bottom = 12.dp, start = 16.dp,end = 16.dp)
            .fillMaxWidth()
            .height(86.dp),
        verticalAlignment = Alignment.Bottom
    ) {

        Text(
            text = "Статистика",
            fontSize = 32.sp,
            textAlign = TextAlign.Start,
        )
    }

}


@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}