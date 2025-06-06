package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatisticCard(lineImage: Painter, arrowImage: Painter, quantity:String, title: String) {
    Box(
        modifier = Modifier.padding(
            horizontal = 16.dp, vertical = 20.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),

            ) {
            Image(
                painter = lineImage,
                contentDescription = "Vector Image",
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Row() {
                    Text(
                        text = quantity,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = arrowImage,
                        contentDescription = "Arrow Image"
                    )
                }
                Text(
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(top = 8.dp),
                    text = title,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}