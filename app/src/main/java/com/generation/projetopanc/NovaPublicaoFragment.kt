package com.generation.projetopanc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.generation.projetopanc.databinding.FragmentPublicarBinding

class NovaPublicaoFragment : Fragment() {
    private lateinit var binding: FragmentPublicarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val titulo = binding.editTitulo.text
        val postagem = binding.editPublicacao.text
        if (titulo != null && postagem != null) {
            binding = FragmentPublicarBinding.inflate(layoutInflater, container, false)
            binding.publisalvarButton.setOnClickListener {
                //  findNavController()
//tem que meter o nav graph quando a gente implementar os card e os caralho
            }
            return binding.root

        }else{
            return null
        }

    }

    }


