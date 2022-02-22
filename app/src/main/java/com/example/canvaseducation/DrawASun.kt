package com.example.canvaseducation

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Sun(

) {
    val radius = 150.dp
    val scaleWidth = 50.dp
    val min = 0
    val max = 359

    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        center = this.center
        circleCenter = Offset(center.x, scaleWidth.toPx() / 2f + radius.toPx())

        drawCircle(
            radius = radius.toPx(),
            center = Offset(circleCenter.x, circleCenter.y),
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                center = Offset(circleCenter.x, circleCenter.y),
                radius = radius.toPx()
            )
        )

        Log.d("DrawAngle", "center = (${center.x}, ${center.y})")
        Log.d("DrawAngle", "circleCenter = (${circleCenter.x}, ${circleCenter.y})")


        var lineStart = Offset(0f, 0f)

        for (i in min..max) {
            var angleInRad = i * (PI / 180f).toFloat()

            if (i % 12 == 0) {
                lineStart = Offset(
                    x = radius.toPx() * cos(angleInRad) + circleCenter.x,
                    y = radius.toPx() * sin(angleInRad) + circleCenter.y
                )
            } else if (i % 6 == 0) {
                val lineEnd = Offset(
                    x = (radius.toPx() + scaleWidth.toPx() / 2f) * cos(angleInRad) + circleCenter.x,
                    y = (radius.toPx() + scaleWidth.toPx() / 2f) * sin(angleInRad) + circleCenter.y
                )
                drawLine(
                    color = Color.Black,
                    start = lineStart,
                    end = lineEnd,
                    strokeWidth = 1.dp.toPx()
                )

                angleInRad = (i + 6) * (PI / 180f).toFloat()

                lineStart = Offset(
                    x = radius.toPx() * cos(angleInRad) + circleCenter.x,
                    y = radius.toPx() * sin(angleInRad) + circleCenter.y
                )
                drawLine(
                    color = Color.Black,
                    start = lineStart,
                    end = lineEnd,
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
    }
}