package com.cidadelimpa.components.form

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.Red

@Composable
fun Input(
    name: String,
    keyboardOptions: KeyboardOptions,
    placeholder: String,
    state: MutableState<String>
) {
    OutlinedTextField(
        value = "${state.value}",
        singleLine = true,
        onValueChange = {
            state.value = it
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        label = {
            Row(verticalAlignment = Alignment.Top) {
                Text(text = "${name}")
                Text(text = "*", color = Red)
            }
        },
        shape = RoundedCornerShape(7.dp),
        placeholder = {
            Text(text = "$placeholder")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = DarkBlue,
            focusedLabelColor = DarkBlue
        )
    )
}