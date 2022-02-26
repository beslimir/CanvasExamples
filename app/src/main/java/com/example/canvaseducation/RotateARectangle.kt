package com.example.canvaseducation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import kotlinx.coroutines.delay

@Composable
fun RotateARectangle() {
    var counter by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = true) {
        while (counter <= 360) {
            counter++
            delay(1L)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        rotate(degrees = counter, pivot = center) {
            drawRect(
                color = Color.Green,
                topLeft = Offset(400f, 200f),
                size = Size(200f, 200f)
            )
        }
    }

}