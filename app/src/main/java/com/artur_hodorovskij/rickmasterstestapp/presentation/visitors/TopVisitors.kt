package com.artur_hodorovskij.rickmasterstestapp.presentation.visitors

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.artur_hodorovskij.rickmasterstestapp.R


@Composable
fun TopVisitors() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Чаще всех посещают Ваш профиль",
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            lineHeight = 28.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box() {
                AsyncImage(
                    model = "https://img.freepik.com/free-photo/smiley-man-relaxing-outdoors_23-2148739334.jpg",
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.BottomEnd),
                    painter = painterResource(R.drawable.isonline),
                    contentDescription = null
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    fontSize = 15.sp,
                    text = "Никнейм," + " 23",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_arrow),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}



