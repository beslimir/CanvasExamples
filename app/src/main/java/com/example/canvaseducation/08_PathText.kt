package com.example.canvaseducation

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas

@Composable
fun TextOnAPath() {
    val path = Path().apply {
        moveTo(200f, 800f)
        quadTo(600f, 400f, 1000f, 800f)
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawContext.canvas.nativeCanvas.apply {
            drawTextOnPath(
                "Hello, Beslimir!",
                path,
                30f,
                50f,
                Paint().apply {
                    color = Color.RED
                    textSize = 70f
                    textAlign = Paint.Align.CENTER
                }
            )
        }
    }
}