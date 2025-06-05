package com.artur_hodorovskij.rickmasterstestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.artur_hodorovskij.rickmasterstestapp.presentation.StatisticScreen
import com.artur_hodorovskij.rickmasterstestapp.ui.theme.RickMastersTestAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickMastersTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Статистика",
                                fontSize = 32.sp,
                                textAlign = TextAlign.Start,
                            )
                        }
                    )
                }) {paddingValues->
                    StatisticScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickMastersTestAppTheme {
        StatisticScreen(modifier = Modifier)
    }
}