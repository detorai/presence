package org.example.project.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PresenceButton(
    text: String,
    onClick: () -> Unit,
    bottom: Int
){
    Button(
        modifier = Modifier.padding(bottom = bottom.dp).fillMaxWidth().height(40.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            disabledContentColor = Color.White  ,
            backgroundColor = Color(0xFF2c2c2c),
            disabledBackgroundColor = Color(0xFFd9d9d9)
        )
    ){
        Text(
            text
        )
    }
}