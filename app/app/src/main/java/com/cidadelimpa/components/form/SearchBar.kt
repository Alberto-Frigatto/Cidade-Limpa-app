package com.cidadelimpa.components.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cidadelimpa.R
import com.cidadelimpa.ui.theme.DarkBlue

@Composable
fun SearchBar()
{
    var query by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = query,
        onValueChange = {
            query= it
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = "Pesquisar localidade")
        },
        shape = RoundedCornerShape(7.dp),
        placeholder = {
            Text(text = "Pesquise por nome ou CEP")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = DarkBlue,
            focusedLabelColor = DarkBlue
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Ínicio",
                modifier = Modifier.size(25.dp)
            )
        }
    )
}