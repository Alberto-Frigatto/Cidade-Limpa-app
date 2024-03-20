package com.cidadelimpa.components.form

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.ExtraLightGrey
import com.cidadelimpa.ui.theme.MediumGrey
import com.cidadelimpa.ui.theme.Red

@Composable
fun Input(
    name: String,
    required: Boolean = true,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions,
    placeholder: String,
    value: String,
    onValueChange: (newValue: String) -> Unit,
    mask: String? = null,
    visualTransformation: VisualTransformation? = null,
    error: Boolean = false
) {
    val transformation = if (mask != null && visualTransformation == null) {

        val offsetMapping = createOffsetMapping(mask)

        VisualTransformation { text ->
            val transformedText = applyMask(mask, text.text)

            TransformedText(
                text = AnnotatedString(transformedText),
                offsetMapping = offsetMapping
            )
        }

    } else {
        VisualTransformation.None
    }

    OutlinedTextField(
        value = value,
        singleLine = true,
        isError = error,
        onValueChange = {
            onValueChange(it)
        },
        enabled = enabled,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        label = {
            Row(verticalAlignment = Alignment.Top) {
                Text(text = name)
                if (required)
                {
                    Text(text = "*", color = Red)
                }
            }
        },
        shape = RoundedCornerShape(7.dp),
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = DarkBlue,
            focusedLabelColor = DarkBlue,
            errorTextColor = Red,
            errorContainerColor = Color(0xFFFFF1F6),
            disabledContainerColor = ExtraLightGrey,
            disabledTextColor = Color(0xFF272727),
            disabledLabelColor = Color(0xFF505050)
        ),
        visualTransformation = visualTransformation ?: transformation
    )
}

private fun applyMask(mask: String, text: String): String {
    var index = 0
    val maskedText = StringBuilder()
    for (char in mask) {
        if (index >= text.length) break
        if (char == '#') {
            maskedText.append(text[index])
            index++
        } else {
            maskedText.append(char)
        }
    }
    return maskedText.toString()
}

private fun createOffsetMapping(mask: String): OffsetMapping {
    return object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            var transformedOffset = offset
            var originalOffset = 0

            mask.forEachIndexed { index, char ->
                if (index >= transformedOffset) return@forEachIndexed
                if (char != '#') transformedOffset++
                if (index < offset && char != '#') originalOffset++
            }
            return transformedOffset
        }

        override fun transformedToOriginal(offset: Int): Int {
            var originalOffset = offset

            mask.forEachIndexed { index, char ->
                if (index >= originalOffset) return@forEachIndexed
                if (char != '#') originalOffset++
            }
            return originalOffset
        }
    }
}
