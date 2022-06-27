package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.generation.projetopanc.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {
    private lateinit var binding:FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        binding.voltarButton.setOnClickListener{
            findNavController().navigate(R.id.action_perfil_to_catalogo)
        }
        return binding.root

    }

}