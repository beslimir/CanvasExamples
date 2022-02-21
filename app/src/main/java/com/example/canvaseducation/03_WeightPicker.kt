package com.example.canvaseducation

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import java.lang.Math.*
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun WeightPicker(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 250,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit,
) {
    val radius = style.radius
    val scaleWidth = style.scaleWidth
    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableStateOf(0f)
    }

    Canvas(modifier = modifier) {
        center = this.center
        circleCenter = Offset(center.x, scaleWidth.toPx() / 2f + radius.toPx())

        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f

        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius.toPx(),
                Paint().apply {
                    strokeWidth = scaleWidth.toPx()
                    color = Color.WHITE
                    setStyle(Paint.Style.STROKE)
                    setShadowLayer(
                        60f,0f, 0f, Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }
        //draw lines
        for (i in minWeight..maxWeight) {
            val angleInRad = (i - initialWeight + angle - 90) * (PI / 180f).toFloat() //degree to rad
            Log.i("TAG", "Angle in RAD: ($i - $initialWeight + $angle - 90) * ($PI / 180f) = $angleInRad")

            val lineType = when {
                i % 10 == 0 -> LineType.TenStep
                i % 5 == 0 -> LineType.FiveStep
                else -> LineType.Normal
            }
            val lineLength = when (lineType) {
                LineType.Normal -> style.normalLineLength.toPx()
                LineType.FiveStep -> style.fiveStepLineLength.toPx()
                LineType.TenStep -> style.tenStepLineLength.toPx()
            }
            val lineColor = when (lineType) {
                LineType.Normal -> style.normalLineColor
                LineType.FiveStep -> style.fiveStepLineColor
                LineType.TenStep -> style.tenStepLineColor
            }
            val lineStart = Offset(
                x = (outerRadius - lineLength) * cos(angleInRad) + circleCenter.x,
                y = (outerRadius - lineLength) * sin(angleInRad) + circleCenter.y
            )
            Log.d("TAG", "Line start: x = ($outerRadius - $lineLength) * ${cos(angleInRad)} + ${circleCenter.x} = ${(outerRadius - lineLength) * cos(angleInRad) + circleCenter.x}")
            Log.d("TAG", "Line start: y = ($outerRadius - $lineLength) * ${sin(angleInRad)} + ${circleCenter.y} = ${(outerRadius - lineLength) * sin(angleInRad) + circleCenter.y}")

            val lineEnd = Offset(
                x = outerRadius * cos(angleInRad) + circleCenter.x,
                y = outerRadius * sin(angleInRad) + circleCenter.y
            )
            Log.v("TAG", "Line end: x = $outerRadius * ${cos(angleInRad)} + ${circleCenter.x} = ${outerRadius * cos(angleInRad) + circleCenter.x}")
            Log.v("TAG", "Line end: y = $outerRadius * ${sin(angleInRad)} + ${circleCenter.y} = ${outerRadius * sin(angleInRad) + circleCenter.y}")

            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd,
                strokeWidth = 1.dp.toPx()
            )
        }

    }

}











