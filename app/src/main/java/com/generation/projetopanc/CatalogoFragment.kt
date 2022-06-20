package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.ProdutosAdapter
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.model.Produtos


class CatalogoFragment : Fragment() {

    private lateinit var binding: FragmentCatalogoBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogoBinding.inflate(layoutInflater,container,false)



        //Configuração do RecyclerView
        val adapter = ProdutosAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)



        return binding.root

    }

}