package com.artur_hodorovskij.rickmasterstestapp.presentation.genderandage

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun TwoLineDonutChart() {

    val percentage1 = Random.nextInt(0, 100).toFloat()
    val percentage2 = 100f - percentage1

    val color1 = Color(0xFFFF9800)
    val color2 = Color(0xFFFFB74D)

    val strokeWidth = 40f

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(250.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val diameter = size.minDimension
                val radius = diameter / 2
                val center = Offset(radius, radius)

                val sweep1 = 360 * (percentage1 / 100f)
                val sweep2 = 360 * (percentage2 / 100f)

                val gapDegrees = 10f

                drawArc(
                    color = color1,
                    startAngle = -90f,
                    sweepAngle = sweep1 - gapDegrees / 2,
                    useCenter = false,
                    topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                    size = Size(diameter - strokeWidth, diameter - strokeWidth),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )

                drawArc(
                    color = color2,
                    startAngle = -90f + sweep1 + gapDegrees / 2,
                    sweepAngle = sweep2 - gapDegrees - gapDegrees/ 2,
                    useCenter = false,
                    topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                    size = Size(diameter - strokeWidth, diameter - strokeWidth),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DonutLegendItem(color1, "Мужчины", percentage1)
            Spacer(modifier = Modifier.width(32.dp))
            DonutLegendItem(color2, "Женщины", percentage2)
        }
    }
}

@Composable
fun DonutLegendItem(color: Color, label: String, percentage: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = color)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "$label: ${percentage.toInt()}%", fontWeight = FontWeight.Bold)
    }
}
