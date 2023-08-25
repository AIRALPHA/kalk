package com.airalpha.kalk.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airalpha.kalk.domain.models.Position
import com.airalpha.kalk.presentation.utilis.getShapeByPosition

@Composable
fun FnButton(
    modifier: Modifier = Modifier,
    text: String,
    position: Position = Position(),
    showPrimaryColor: Boolean = true,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.minus(16 * 2)
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (showPrimaryColor) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.onBackground.copy(
                .3f
            ),
            contentColor = if (showPrimaryColor) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onBackground,
        ),
        shape = getShapeByPosition(position),
        modifier = modifier
            .height(72.dp)
            .width(screenWidth.dp / 4)
            .then(
                when {
                    position.first && position.last.not() -> Modifier.padding(end = 4.dp)
                    position.last -> Modifier
                    else -> Modifier.padding(end = 4.dp)
                }
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium
        )
    }
}