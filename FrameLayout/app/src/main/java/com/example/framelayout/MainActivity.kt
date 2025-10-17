package com.example.framelayout

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Variable que maneja el reproductor de audio
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imagenOursense = findViewById<ImageView>(R.id.imageView1)
        val imagenSantiago = findViewById<ImageView>(R.id.imageView2)
        val textoModficar = findViewById<TextView>(R.id.textView3)

        imagenOursense.setOnClickListener {
            textoModficar.text = getString(R.string.ourense_desc)
            // Reprodución del audio
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this, R.raw.audio)
            mediaPlayer?.start()

        }
        imagenSantiago.setOnClickListener {
            textoModficar.text = getString(R.string.santiago_desc)
            // Reprodución del audio
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this, R.raw.audio)
            mediaPlayer?.start()
        }
    }

    override fun onDestroy() {
        // Destruye el reproductor de audio al destruir la actividad
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}