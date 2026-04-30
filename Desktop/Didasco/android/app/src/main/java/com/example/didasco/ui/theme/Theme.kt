package com.example.didasco.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val StudentColorScheme = lightColorScheme(
    primary = StudentPrimary,
    secondary = StudentSecondary,
    background = StudentBackground,
    surface = StudentSurface,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.Black,
    onBackground = androidx.compose.ui.graphics.Color.Black,
    onSurface = androidx.compose.ui.graphics.Color.Black
)

private val TeacherColorScheme = lightColorScheme(
    primary = TeacherPrimary,
    secondary = TeacherSecondary,
    background = TeacherBackground,
    surface = TeacherSurface,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.Black,
    onBackground = androidx.compose.ui.graphics.Color.Black,
    onSurface = androidx.compose.ui.graphics.Color.Black
)

@Composable
fun DidascoTheme(
    isStudent: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isStudent) StudentColorScheme else TeacherColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
