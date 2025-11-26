package com.example.calculadoravelocidadmedia

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.calculadoravelocidadmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val kilometros = MutableLiveData<String>("0")
    private val horas = MutableLiveData<String>("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.cantidadKm.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                kilometros.value = s?.toString() ?: "0"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        binding.cantidadHoras.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                horas.value = s?.toString() ?: "0"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        val observer = Observer<String> {
            val km = kilometros.value?.toIntOrNull() ?: 0
            val h = horas.value?.toIntOrNull() ?: 0
            if (h!=0) {
                val kmPorHora = km/h
                val mPorSegundo = (km*1000)/(h*3600)
                binding.kilometrosHora.text = kmPorHora.toString()
                binding.metrosSegundo.text = mPorSegundo.toString()
                binding.mensajeError.text = getString(R.string.error_message)
            }
            else {
                binding.kilometrosHora.text = "0"
                binding.metrosSegundo.text = "0"
                binding.mensajeError.text = getString(R.string.error_message_alt)
                //Toast.makeText(this, "Esta feo eso de indicar 0 horas o nada", Toast.LENGTH_LONG).show()

            }
        }
        kilometros.observe(this, observer)
        horas.observe(this, observer)

    }
}