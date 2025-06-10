package com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.visitors

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.StatisticScreenState
import com.artur_hodorovskij.rickmasterstestapp.presentation.statistic.StatisticViewModel
import com.artur_hodorovskij.rickmasterstestapp.ui.theme.AxisColor
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.absoluteValue


@Composable
fun DailyDiagram(content: StatisticScreenState.Content, viewModel: StatisticViewModel) {

    val statisticList = content.statisticList.statistics
    val points = viewModel.preparePoints(statisticList)
    val pointList = remember(statisticList) { points }
    val max = (pointList.maxOfOrNull { it.y } ?: 0f)
    val min = (pointList.minOfOrNull { it.y } ?: 0f)
    val paddingDiagram = 16.dp
    val lineColor = MaterialTheme.colorScheme.primary
    val diagramBackground = MaterialTheme.colorScheme.background
    var touchPosition by remember { mutableStateOf<Offset?>(null) }
    val pointWidth = 80.dp
    val canvasWidth = 40.dp + pointWidth * pointList.size

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
            .horizontalScroll(rememberScrollState(), reverseScrolling = false)
    ) {
        Canvas(
            modifier = Modifier
                .width(canvasWidth)
                .fillMaxHeight()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        touchPosition = offset
                    }
                }
        ) {

            val canvasHeight = size.height
            val verticalMargin = 40.dp.toPx()

            val leftPadding = paddingDiagram.toPx() + 5.dp.toPx()
            val bottomPadding = paddingDiagram.toPx()
            val topPadding = paddingDiagram.toPx()

            val graphHeight = canvasHeight - topPadding - bottomPadding - 2 * verticalMargin

            val dashEffect = PathEffect.dashPathEffect(floatArrayOf(50f, 30f), 0f)

            drawLine(
                color = AxisColor,
                start = Offset(leftPadding, canvasHeight - bottomPadding),
                end = Offset(size.width, canvasHeight - bottomPadding),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )

            drawLine(
                color = AxisColor,
                start = Offset(leftPadding, canvasHeight / 2),
                end = Offset(size.width, canvasHeight / 2),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )

            drawLine(
                color = AxisColor,
                start = Offset(leftPadding, topPadding),
                end = Offset(size.width, topPadding),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )

            if (pointList.size < 2) return@Canvas

            val xStep = pointWidth.toPx()
            val yRange = (max - min).takeIf { it != 0f } ?: 1f

            val scaledPoints = pointList.mapIndexed { index, point ->
                val x = 40.dp.toPx() + leftPadding + index * xStep
                val yRatio = (point.y - min) / yRange
                val y = canvasHeight - bottomPadding - verticalMargin - yRatio * graphHeight
                Pair(Offset(x, y), point)
            }

            for (i in 0 until scaledPoints.size - 1) {
                drawLine(
                    color = lineColor,
                    start = scaledPoints[i].first,
                    end = scaledPoints[i + 1].first,
                    strokeWidth = 4.dp.toPx()
                )
            }

            scaledPoints.forEach {
                drawCircle(
                    color = lineColor,
                    radius = 6.dp.toPx(),
                    center = it.first
                )

                drawCircle(
                    color = diagramBackground,
                    radius = 3.dp.toPx(),
                    center = it.first
                )
            }

            scaledPoints.forEachIndexed { _, (offset, point) ->
                val dayStr = String.format("%02d", point.date.dayOfMonth)
                val monthStr = String.format("%02d", point.date.monthValue)
                drawContext.canvas.nativeCanvas.drawText(
                    "$dayStr.$monthStr",
                    offset.x,
                    canvasHeight + 3.sp.toPx(),
                    Paint().apply {
                        color = Color.Gray.toArgb()
                        textAlign = Paint.Align.CENTER
                        textSize = 15.sp.toPx()
                    }
                )
            }

            touchPosition?.let { touch ->
                val closest = scaledPoints.minByOrNull { (pointOffset, _) ->
                    (pointOffset.x - touch.x).absoluteValue
                }
                closest?.let { (closestOffset, point) ->

                    drawLine(
                        color = lineColor,
                        start = closestOffset,
                        end = Offset(
                            closestOffset.x,
                            canvasHeight - bottomPadding
                        ),
                        strokeWidth = 2.dp.toPx(),
                        pathEffect = dashEffect
                    )
                    val popupWidth = 128.dp.toPx()
                    val popupHeight = 72.dp.toPx()
                    val popupX = (closestOffset.x - popupWidth / 2f).coerceIn(
                        10f,
                        size.width - popupWidth - 10f
                    )
                    val popupY = closestOffset.y - popupHeight

                    drawRoundRect(
                        color = diagramBackground,
                        topLeft = Offset(popupX, popupY),
                        size = Size(popupWidth, popupHeight),
                        cornerRadius = CornerRadius(8.dp.toPx())
                    )

                    drawRoundRect(
                        color = AxisColor,
                        topLeft = Offset(popupX, popupY),
                        size = Size(popupWidth, popupHeight),
                        cornerRadius = CornerRadius(8.dp.toPx()),
                        style = Stroke(width = 1f)
                    )

                    drawContext.canvas.nativeCanvas.apply {
                        val paintY = Paint().apply {
                            color = lineColor.toArgb()
                            textSize = 15.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            isAntiAlias = true
                        }
                        val paintX = Paint().apply {
                            color = Color.Gray.toArgb()
                            textSize = 15.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            isAntiAlias = true
                        }

                        val centerX = popupX + popupWidth / 2f
                        val yPosY = popupY + popupHeight / 3f + 15.sp.toPx() / 2f
                        val yPosX = popupY + 2 * popupHeight / 3f + 15.sp.toPx() / 2f

                        drawText("${point.y.toInt()} посетитель", centerX, yPosY, paintY)

                        val monthName =
                            point.date.month.getDisplayName(TextStyle.FULL, Locale("ru"))
                        drawText("${point.date.dayOfMonth} $monthName", centerX, yPosX, paintX)
                    }
                }
            }
        }
    }
}

