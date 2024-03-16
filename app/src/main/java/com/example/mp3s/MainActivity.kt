package com.example.mp3s

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mp3s.ui.theme.Mp3sTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mp3sTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaPlayer()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mp3sTheme {
        Greeting("Android")
    }
}

//@Composable
//fun MediaPlayer() {
//    // States to manage media player functionality
//    val context = LocalContext.current
//    val mediaPlayer = remember { android.media.MediaPlayer.create(context, R.raw.bgm) }
//    val isPlaying = remember { mutableStateOf(false) }
//    val songDuration = remember { mutableStateOf(300f) } // Initial song duration (in seconds)
//    val currentProgress = remember { mutableStateOf(0f) } // Current progress of the song (in seconds)
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        Text("Media Player", fontSize = 24.sp)
//        Slider(
//            value = currentProgress.value,
//            onValueChange = { currentProgress.value = it },
//            valueRange = 0f..songDuration.value,
//            colors = SliderDefaults.colors(thumbColor = Color.Black),
//            modifier = Modifier.fillMaxWidth()
//        )
//        Button(
//            onClick = { isPlaying.value = !isPlaying.value },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(if (isPlaying.value) "Pause" else "Play")
//        }
//
//        Button(
//            onClick = { /* Stop functionality */ },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Stop")
//        }
//
//        Text("Song Duration: ${songDuration.value.toInt()} seconds")
//
//    }
//}