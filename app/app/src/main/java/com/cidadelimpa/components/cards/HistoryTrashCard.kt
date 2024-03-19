package com.cidadelimpa.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular
import kotlin.random.Random

@Composable
fun HistoryTrashCard(
    address: String
) {
    val trashCapacity = Random.nextInt(80, 121)
    val organicOccupated = Random.nextInt(0, 101)
    val recycledOccupated = Random.nextInt(0, 101)

    Card(
        modifier = Modifier.background(Color.White),
        border = BorderStroke(1.dp, DarkBlue),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column (
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                text = address,
                fontFamily = roboto_regular
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Orgânico",
                        fontFamily = roboto_bold,
                        fontSize = 18.sp
                    )
                    Column {
                        Text(
                            text = "Capacidade: ${trashCapacity}L",
                            fontFamily = roboto_regular
                        )
                        Text(
                            text = "Ocupado: ${organicOccupated}%",
                            fontFamily = roboto_regular
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Reciclado",
                        fontFamily = roboto_bold,
                        fontSize = 18.sp
                    )
                    Column {
                        Text(
                            text = "Capacidade: ${trashCapacity}L",
                            fontFamily = roboto_regular
                        )
                        Text(
                            text = "Ocupado: ${recycledOccupated}%",
                            fontFamily = roboto_regular
                        )
                    }
                }
            }
        }
    }
}