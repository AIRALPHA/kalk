package com.airalpha.kalk.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ResultCalc(text: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End
    ) {
        Text(
            text,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.End
        )
    }
}