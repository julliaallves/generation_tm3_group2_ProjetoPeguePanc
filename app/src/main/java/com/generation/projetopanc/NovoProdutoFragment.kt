package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.generation.projetopanc.databinding.FragmentNovoProdutoBinding

class NovoProdutoFragment : Fragment() {

    private lateinit var binding : FragmentNovoProdutoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNovoProdutoBinding.inflate(layoutInflater,container, false)



        return binding.root

    }


}
