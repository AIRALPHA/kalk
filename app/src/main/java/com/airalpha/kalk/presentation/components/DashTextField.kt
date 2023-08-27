package com.airalpha.kalk.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashTextField() {
    TextField(
        value = "first",
        onValueChange = {},
        colors = TextFieldDefaults.textFieldColors(
            unfocusedLabelColor = MaterialTheme.colorScheme.background,
            focusedLabelColor = MaterialTheme.colorScheme.background,
            containerColor = MaterialTheme.colorScheme.background,
            focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
            cursorColor = MaterialTheme.colorScheme.onBackground,
            textColor = MaterialTheme.colorScheme.onBackground,
        )
    )
}

@Composable
fun DashedDivider(
    thickness: Dp,
    color: Color = Color.White,
    phase: Float = 10f,
    intervals: FloatArray = floatArrayOf(15f, 15f),
    modifier: Modifier
) {
    Canvas(
        modifier = modifier
    ) {
        val dividerHeight = thickness.toPx()
        drawRoundRect(
            color = color,
            style = Stroke(
                width = dividerHeight,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = intervals,
                    phase = phase
                )
            )
        )
    }
}