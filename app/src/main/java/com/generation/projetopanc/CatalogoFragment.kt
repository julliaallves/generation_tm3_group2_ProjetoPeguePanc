package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.ProdutosAdapter
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.model.Produtos


class CatalogoFragment : Fragment() {

    private lateinit var binding: FragmentCatalogoBinding
    private val mainviewmodel : MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogoBinding.inflate(layoutInflater,container,false)
        mainviewmodel.listProdutos()



        //Configuração do RecyclerView
        val adapter = ProdutosAdapter()
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        mainviewmodel.myProdutosResponse.observe(viewLifecycleOwner){
            response -> if(response.body() != null){
                            adapter.setList(response.body()!!)
            }
        }



        return binding.root

    }

}