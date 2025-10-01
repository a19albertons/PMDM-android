package com.example.historiaslocal

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val textView = findViewById<TextView>(R.id.texto)
        val button = findViewById<Button>(R.id.boton)
        button.setOnClickListener {
            textView.text = generarHistoria()
        }
    }
}

fun generarHistoria(): String {
    val introducciones = listOf(
        "En un pequeño pueblo olvidado,",
        "Una vez, en una galaxia lejana,",
        "En medio de un bosque misterioso,"
    )
    val desarrollo = listOf(
        "desarrollo1",
        "desarrollo2",
        "desarrollo3"
    )
    val final = listOf(
        "En un pequeño pueblo olvidado,",
        "Una vez, en una galaxia lejana,",
        "En medio de un bosque misterioso,"
    )
    val devolver = introducciones[Random.nextInt(3)]+desarrollo[Random.nextInt(3)]+final[Random.nextInt(3)]
    return devolver
}