package com.airalpha.kalk.presentation.utilis

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ShapeDefaults
import androidx.compose.ui.unit.dp
import com.airalpha.kalk.domain.models.Position

fun getShapeByPosition(position: Position): CornerBasedShape {
    val defaultShapes = ShapeDefaults.Small.copy(CornerSize(2.dp))
    if(position == Position()) return defaultShapes
    return defaultShapes.copy(
        topStart = if (position.top && position.first) CornerSize(8.dp) else CornerSize(2.dp),
        topEnd = if (position.top && position.last) CornerSize(8.dp) else CornerSize(2.dp),
        bottomStart = if (position.bottom && position.first) CornerSize(8.dp) else CornerSize(2.dp),
        bottomEnd = if (position.bottom && position.last) CornerSize(8.dp) else CornerSize(2.dp),
    )
}