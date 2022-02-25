package com.example.canvaseducation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

//cubicTo uses 2 points, quadraticBezierTo uses 1

@Composable
fun PathBasics() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(1000f, 100f)
            lineTo(100f, 500f)
            lineTo(500f, 500f)
//            quadraticBezierTo(
//                800f,300f,
//                500f,100f
//            )
            cubicTo(
                800f, 500f,
                800f, 100f,
                500f, 100f
            )
//            lineTo(100f, 100f) //or use close()
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Miter,
                miter = 2f
            )
        )
    }
}