package com.artur_hodorovskij.rickmasterstestapp.presentation.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.R


@Composable
fun Visitors() {
    Box() {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Посетители",
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
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.growth_line),
                        contentDescription = "Vector Image"
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Row {
                            Text(
                                text = "1356",
                                fontSize = 20.sp,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(id = R.drawable.arrow_up),
                                contentDescription = "",
                                alignment = Alignment.BottomCenter
                            )
                        }
                        Text(
                            modifier = Modifier.alpha(0.5f),
                            text = "Количество посетителей в этом месяце выросло",
                            fontSize = 15.sp,
                            textAlign = TextAlign.Start
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun VisitorsPreview() {
    Visitors()
}