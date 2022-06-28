package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.CarrinhoAdapter
import com.generation.projetopanc.adapter.ProdutosAdapter
import com.generation.projetopanc.databinding.FragmentCarrinhoBinding
import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos

class CarrinhoFragment : Fragment() {

    private lateinit var binding: FragmentCarrinhoBinding
    private lateinit var carrinhoViewModel: CarrinhoViewModel
    private val mainviewmodel : MainViewModel by activityViewModels()
    private var listCategoria = emptyList<Produtos>()
    private val carrinhoAdapter: CarrinhoAdapter by lazy {
        CarrinhoAdapter(carrinhoViewModel, mainviewmodel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrinhoBinding.inflate(layoutInflater, container, false)

        carrinhoViewModel = ViewModelProvider(this).get(CarrinhoViewModel::class.java)


        val adapter = CarrinhoAdapter(carrinhoViewModel, mainviewmodel)
        binding.recyclerCarrinho.layoutManager = LinearLayoutManager(context)
        binding.recyclerCarrinho.adapter = adapter
        binding.recyclerCarrinho.setHasFixedSize(true)

        setAdapter()

        carrinhoViewModel.getAllCarrinho.observe(viewLifecycleOwner){
            response -> adapter.setList(response)
            carrinhoAdapter.setTotal(response)
            binding.textTotal.text = carrinhoViewModel.total.toString()
        }






        binding.buttonAdicionarOutroItem.setOnClickListener {
            findNavController().navigate(R.id.action_carrinho_to_catalogo)
        }
        binding.buttonComprar.setOnClickListener{
            carrinhoViewModel.deleteAllCarrinho()
            Toast.makeText(requireContext(),"REALIZADO COM SUCESSO", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_carrinho_to_catalogo)
        }
        return binding.root

    }

    private fun setAdapter(){
        mainviewmodel.myProdutosResponse.observe(viewLifecycleOwner){
                response -> if(response.body() != null){
            carrinhoAdapter.setListProdutos(response.body()!!)
        }

        }
    }

}