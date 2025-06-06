package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.genderandage

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun GenderDonutDiagram() {

    val primaryPercentage = Random.nextInt(0, 100).toFloat()
    val secondaryPercentage = 100f - primaryPercentage

    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary

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

                val sweep1 = 360 * (primaryPercentage / 100f)
                val sweep2 = 360 * (secondaryPercentage / 100f)

                val gapDegrees = 10f

                drawArc(
                    color = primaryColor,
                    startAngle = -90f,
                    sweepAngle = sweep1 - gapDegrees / 2,
                    useCenter = false,
                    topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                    size = Size(diameter - strokeWidth, diameter - strokeWidth),
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                )

                drawArc(
                    color = secondaryColor,
                    startAngle = -90f + sweep1 + gapDegrees / 2,
                    sweepAngle = sweep2 - gapDegrees - gapDegrees / 2,
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
            DonutLegendItem(primaryColor, "Мужчины", primaryPercentage)
            Spacer(modifier = Modifier.width(32.dp))
            DonutLegendItem(secondaryColor, "Женщины", secondaryPercentage)
        }
    }
}

