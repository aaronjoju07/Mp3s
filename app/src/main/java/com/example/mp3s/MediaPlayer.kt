package com.example.mp3s

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.media.MediaPlayer
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text

@Composable
fun MediaPlayer() {
    val context = LocalContext.current

    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }
    var isPlaying by remember { mutableStateOf(false) }
    var songDuration by remember { mutableStateOf(0) }
    var currentProgress by remember { mutableStateOf(0) }

    DisposableEffect(Unit) {
        mediaPlayer = MediaPlayer.create(context, R.raw.bgm)
        songDuration = mediaPlayer?.duration ?: 0

        onDispose {
            mediaPlayer?.release()
        }
    }

    val togglePlayback: () -> Unit = {
        if (isPlaying) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
        }
        isPlaying = !isPlaying
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = togglePlayback,
            modifier = Modifier.fillMaxWidth()
        ) {
            val buttonText = if (isPlaying) "Pause" else "Play"
            Text(buttonText)
        }

        Slider(
            value = currentProgress.toFloat(),
            onValueChange = { newValue ->
                currentProgress = newValue.toInt()
                mediaPlayer?.seekTo(currentProgress * 1000)
            },
            valueRange = 0f..songDuration.toFloat(),
            steps = 100,
            modifier = Modifier.fillMaxWidth()
        )

        // Other player controls can be added here
        // For example:
        Button(
            onClick = { mediaPlayer?.seekTo(mediaPlayer?.currentPosition?.plus(5000) ?: 0) }, // Seek forward by 5 seconds
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Seek Forward")
        }

        Button(
            onClick = { mediaPlayer?.seekTo(mediaPlayer?.currentPosition?.minus(5000) ?: 0) }, // Seek backward by 5 seconds
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Seek Backward")
        }
    }
}
