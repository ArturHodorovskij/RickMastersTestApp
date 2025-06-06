package com.artur_hodorovskij.rickmasterstestapp.presentation.genderandage

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun GenderAndAgeBarDiagram(
    modifier: Modifier = Modifier,
    labels: List<String> = listOf("18-22", "22-25", "26-30", "31-35", "36-40", "40-50", ">50"),
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val textColor = MaterialTheme.colorScheme.onPrimary

    val rowHeightDp = 40.dp
    val labelWidthDp = 70.dp

    val data = remember {
        labels.map { label ->
            RandomData(
                label,
                percent1 = Random.nextFloat() * 100f,
            )
        }
    }

    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        data.forEach { entry ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(rowHeightDp)
            ) {
                Text(
                    text = entry.label,
                    fontSize = 18.sp,
                    modifier = Modifier.width(labelWidthDp),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.width(12.dp))

                Canvas(
                    modifier = Modifier
                        .height(24.dp)
                        .fillMaxWidth()
                ) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    val lineHeight = canvasHeight / 3f

                    val lineMaxWidth = canvasWidth * 0.75f

                    val length1 = lineMaxWidth * (entry.percent1 / 100f)
                    val length2 = lineMaxWidth * (entry.percent2 / 100f)

                    drawLine(
                        color = primaryColor,
                        strokeWidth = lineHeight,
                        cap = StrokeCap.Round,
                        start = Offset(0f, lineHeight / 2),
                        end = Offset(length1, lineHeight / 2)
                    )

                    drawLine(
                        color = secondaryColor,
                        strokeWidth = lineHeight,
                        cap = StrokeCap.Round,
                        start = Offset(0f, lineHeight * 3),
                        end = Offset(length2, lineHeight * 3)
                    )

                    drawContext.canvas.nativeCanvas.apply {
                        val textPaint = Paint().apply {
                            color = textColor.toArgb()
                            textSize = 12.sp.toPx()
                            isAntiAlias = true
                            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
                        }
                        val offsetX = 8.dp.toPx()

                        val text1 = "${entry.percent1.roundToInt()}%"
                        val text2 = "${entry.percent2.roundToInt()}%"

                        val y1 = lineHeight / 2 + (textPaint.textSize / 3)
                        val y2 = lineHeight * 3 + (textPaint.textSize / 3)

                        val x1 = (length1 + offsetX).coerceAtMost(
                            canvasWidth - textPaint.measureText(text1)
                        )
                        val x2 = (length2 + offsetX).coerceAtMost(
                            canvasWidth - textPaint.measureText(text2)
                        )

                        drawText(text1, x1, y1, textPaint)
                        drawText(text2, x2, y2, textPaint)
                    }
                }
            }
        }
    }
}

data class RandomData(val label: String, val percent1: Float, val percent2: Float = 100f - percent1)
