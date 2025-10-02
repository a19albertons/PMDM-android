package com.example.constraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val usuario = findViewById<EditText>(R.id.textView2)
        val contrasena = findViewById<EditText>(R.id.textView)
        val modificar = findViewById<TextView>(R.id.textView3)
        val boton = findViewById<Button>(R.id.button)
        boton.setOnClickListener {
            modificar.text = "Usuario: "+usuario.text+" contrasena: "+contrasena.text
        }
    }
}