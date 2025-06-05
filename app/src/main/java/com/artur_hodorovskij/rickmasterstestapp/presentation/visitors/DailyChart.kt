package com.artur_hodorovskij.rickmasterstestapp.presentation.visitors

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue
import kotlin.random.Random

@Composable
fun DailyChart() {
    val pointList = remember { getPointList() }
    val max = getMax(pointList)
    val min = getMin(pointList)
    val padding = 16.dp
    val axisColor = Color.Gray
    val lineColor = Color(0xFFFF9800)

    var touchPosition by remember { mutableStateOf<Offset?>(null) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        touchPosition = offset
                    }
                }
        ) {

            val canvasWidth = size.width
            val canvasHeight = size.height

            val leftPadding = padding.toPx()
            val bottomPadding = padding.toPx()
            val topPadding = padding.toPx()

            val graphWidth = canvasWidth - leftPadding
            val graphHeight = canvasHeight - topPadding - bottomPadding

            val dashEffect = PathEffect.dashPathEffect(floatArrayOf(50f, 30f), 0f)

            drawLine(
                color = axisColor,
                start = Offset(leftPadding, canvasHeight - bottomPadding),
                end = Offset(canvasWidth, canvasHeight - bottomPadding),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )
            drawLine(
                color = axisColor,
                start = Offset(leftPadding, canvasHeight / 2),
                end = Offset(canvasWidth, canvasHeight / 2),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )
            drawLine(
                color = axisColor,
                start = Offset(leftPadding, topPadding),
                end = Offset(canvasWidth, topPadding),
                strokeWidth = 2.dp.toPx(),
                pathEffect = dashEffect
            )

            val xStep = graphWidth / (pointList.size - 1)
            val yRange = max - min

            val scaledPoints = pointList.mapIndexed { index, point ->
                val x = leftPadding + index * xStep
                val yRatio = (point.y - min) / yRange
                val y = canvasHeight - bottomPadding - yRatio * graphHeight
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
                    color = Color.White,
                    radius = 3.dp.toPx(),
                    center = it.first
                )
            }

            scaledPoints.forEachIndexed { index, (offset, _) ->
                drawContext.canvas.nativeCanvas.drawText(
                    index.toString(),
                    offset.x,
                    canvasHeight + 3.sp.toPx(),
                    android.graphics.Paint().apply {
                        color = android.graphics.Color.GRAY
                        textAlign = android.graphics.Paint.Align.CENTER
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
                    val popupWidth = 100.dp.toPx()
                    val popupHeight = 40.dp.toPx()
                    val popupX = (closestOffset.x - popupWidth / 2f).coerceIn(
                        10f,
                        canvasWidth - popupWidth - 10f
                    )
                    val popupY = closestOffset.y - popupHeight

                    drawRoundRect(
                        color = Color.White,
                        topLeft = Offset(popupX, popupY),
                        size = androidx.compose.ui.geometry.Size(popupWidth, popupHeight),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
                    )
                    drawRoundRect(
                        color = lineColor,
                        topLeft = Offset(popupX, popupY),
                        size = androidx.compose.ui.geometry.Size(popupWidth, popupHeight),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx()),
                        style = Stroke(width = 2f)
                    )

                    drawContext.canvas.nativeCanvas.apply {
                        val paintY = android.graphics.Paint().apply {
                            color = lineColor.toArgb()
                            textSize = 15.sp.toPx()
                            textAlign = android.graphics.Paint.Align.CENTER
                            isAntiAlias = true
                        }
                        val paintX = android.graphics.Paint().apply {
                            color = Color.Gray.toArgb()
                            textSize = 15.sp.toPx()
                            textAlign = android.graphics.Paint.Align.CENTER
                            isAntiAlias = true
                        }
                        val centerX = popupX + popupWidth / 2f
                        val yPosY = popupY + popupHeight / 3f + 15.sp.toPx() / 2f
                        val yPosX = popupY + 2 * popupHeight / 3f + 15.sp.toPx() / 2f

                        drawText("${point.y.toInt()}", centerX, yPosY, paintY)
                        drawText("${point.x.toInt()}", centerX, yPosX, paintX)
                    }

                    drawCircle(
                        color = Color.Black,
                        radius = 8f,
                        center = closestOffset,
                        style = Stroke(width = 2f)
                    )
                }
            }
        }
    }
}

fun getPointList(): List<Point> {
    val list = ArrayList<Point>()
    for (i in 0..7) list.add(
        Point(
            i.toFloat(),
            Random.nextInt(0, 100).toFloat()
        )
    )
    return list
}

fun getMax(list: List<Point>): Float {
    if (list.isEmpty()) return 0f
    var max = list.first().y
    list.forEach { point -> if (max < point.y) max = point.y }
    return max
}

fun getMin(list: List<Point>): Float {
    if (list.isEmpty()) return 0f
    var min = list.first().y
    list.forEach { point -> if (min > point.y) min = point.y }
    return min
}

data class Point(val x: Float, val y: Float)
