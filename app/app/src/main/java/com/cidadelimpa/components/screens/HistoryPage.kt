package com.cidadelimpa.components.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavController
import com.cidadelimpa.components.cards.HistoryTrashCard
import com.cidadelimpa.components.layout.ColumnCenter
import com.cidadelimpa.components.layout.Footer
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.MediumGrey
import com.cidadelimpa.ui.theme.roboto_bold
import com.cidadelimpa.ui.theme.roboto_regular

@Composable
fun HistoryPage(navController: NavController)
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            Text(
                text = "Abaixo estão todas as lixeiras que você consultou",
                fontFamily = roboto_bold,
                fontSize = 20.sp
            )
            
            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                HistoryTrashCard(
                    address = "Avenida Monte Sião da Silva 109, Mooca, São Paulo - SP"
                )
                HistoryTrashCard(address = "Rua das Flores 45, Jardim das Américas, São Paulo - SP")
                HistoryTrashCard(address = "Avenida Brasil 234, Centro, São Paulo - SP")
                HistoryTrashCard(address = "Rua Sete de Setembro 567, Savassi, São Paulo - SP")
                HistoryTrashCard(address = "Avenida Paulista 890, Bela Vista, São Paulo - SP")
                HistoryTrashCard(address = "Rua XV de Novembro 76, Centro Histórico, São Paulo - SP")
            }
        }
        Footer(
            modifier = Modifier
                .border(1.dp, MediumGrey)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(0.dp)
                .background(Color.White),
            navController = navController,
            activeBtnId = 2
        )
    }
}