package com.example.uf1_ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.uf1_ud06_3_guessgame.databinding.FragmentGameBinding
import com.google.android.material.snackbar.Snackbar

class GameFragment : Fragment() {
    val model: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        //Inicializamos la palabra
        updateScreen()

        binding.buttonNext.setOnClickListener {
            //model.secretWord = "Prueba de modelo"
            if(binding.txtGuess.text.length>0){
                //Comprobar la letra introducida
                model.makeGuess(binding.txtGuess.text.toString())
                //Actualizamos la pantalla
                updateScreen()
                //Si acertamos la palabra o nos quedamos sin vidas
                if (model.win() || model.lost())
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }else{
                //Sino se introduce ningún texto mostramos un aviso
                Snackbar.make(view, "Introduce una letra", Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

    fun updateScreen(){
        binding.txtWord.text = model.secretWordDisplay.value
        binding.txtLives.text = "Te quedan ${model.lives.value} vidas"
        binding.txtGuess.text = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}