package com.example.canvaseducation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotateARectangle()

//            Lines below are used for WeightPicker()

//            var weight by remember {
//                mutableStateOf(80)
//            }
//
//            Box(modifier = Modifier.fillMaxSize()) {
//                WeightPicker(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp)
//                        .align(Alignment.BottomCenter),
//                    style = ScaleStyle(
//                        scaleWidth = 150.dp
//                    )
//                ) {
//                    weight = it
//                }
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(400.dp)
//                        .align(Alignment.BottomCenter),
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = weight.toString(),
//                        style = TextStyle(
//                            fontSize = 50.sp
//                        )
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = "KG",
//                        modifier = Modifier
//                            .padding(top = 20.dp),
//                        style = TextStyle(
//                            fontSize = 30.sp
//                        ),
//                        color = Color.Green
//                    )
//                }
//            }
        }
    }
}










