package com.cidadelimpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cidadelimpa.ui.theme.Aqua
import com.cidadelimpa.ui.theme.CidadeLimpaTheme
import com.cidadelimpa.ui.theme.DarkBlue
import com.cidadelimpa.ui.theme.ExtraLightGrey
import com.cidadelimpa.ui.theme.LightGrey
import com.cidadelimpa.ui.theme.roboto_regular

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CidadeLimpaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomePage()
                }
            }
        }
    }
}

@Composable
fun WelcomePage()
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cidade_limpa),
            contentDescription = "logo",
            modifier = Modifier.size(220.dp)
        )
        
        Spacer(modifier = Modifier.height(70.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                contentPadding = PaddingValues(18.dp, 13.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue, contentColor = Aqua)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = 22.sp,
                        fontFamily = roboto_regular
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = "Seta para a direita",
                        modifier = Modifier.size(27.dp)
                    )
                }
            }

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                contentPadding = PaddingValues(18.dp, 13.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = DarkBlue),
                border = BorderStroke(2.dp, DarkBlue)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                ) {
                    Text(
                        text = "Criar conta",
                        fontSize = 22.sp,
                        fontFamily = roboto_regular
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.person_fill),
                        contentDescription = "Seta para a direita",
                        modifier = Modifier.size(27.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Ou",
            fontSize = 18.sp,
            fontFamily = roboto_regular
        )

        Spacer(modifier = Modifier.height(60.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(250.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(1.dp, color = Color(0xFFDBDBDB), RoundedCornerShape(50.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Google",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
            Image(
                painter = painterResource(id = R.drawable.gov),
                contentDescription = "Google",
                modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .border(1.dp, color = Color(0xFFDBDBDB), RoundedCornerShape(50.dp))
            )
        }
    }
}