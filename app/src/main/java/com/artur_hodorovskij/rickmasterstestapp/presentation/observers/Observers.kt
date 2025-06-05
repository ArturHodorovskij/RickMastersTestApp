package com.artur_hodorovskij.rickmasterstestapp.presentation.observers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.R

@Composable
fun Observers() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Наблюдатели",
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp
        )
        Box(
            modifier = Modifier.padding(
                horizontal = 16.dp, vertical = 20.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.growth_line),
                    contentDescription = "Vector Image",
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    Row() {
                        Text(
                            text = "1356",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = ""
                        )
                    }
                    Text(
                        modifier = Modifier
                            .alpha(0.5f)
                            .padding(top = 8.dp),
                        text = "Новые наблюдатели в этом месяце",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
        Box(
            modifier = Modifier.padding(
                horizontal = 16.dp,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.falling_line),
                    contentDescription = "Vector Image",
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    Row() {
                        Text(
                            text = "1356",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = ""
                        )
                    }
                    Text(
                        modifier = Modifier
                            .alpha(0.5f)
                            .padding(top = 8.dp),
                        text = "Пользователей перестали за вами наблюдать",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }

    }
}