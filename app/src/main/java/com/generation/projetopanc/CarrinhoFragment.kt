package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.CarrinhoAdapter
import com.generation.projetopanc.databinding.FragmentCarrinhoBinding
import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos

class CarrinhoFragment : Fragment() {

    private lateinit var binding: FragmentCarrinhoBinding
    private lateinit var carrinhoViewModel: CarrinhoViewModel
    private val mainviewmodel : MainViewModel by activityViewModels()
    private var listCategoria = emptyList<Produtos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrinhoBinding.inflate(layoutInflater, container, false)

        carrinhoViewModel = ViewModelProvider(this).get(CarrinhoViewModel::class.java)


        val adapter = CarrinhoAdapter(carrinhoViewModel)
        binding.recyclerCarrinho.layoutManager = LinearLayoutManager(context)
        binding.recyclerCarrinho.adapter = adapter
        binding.recyclerCarrinho.setHasFixedSize(true)

        carrinhoViewModel.getAllCarrinho.observe(viewLifecycleOwner){
            response -> adapter.setList(response)
        }

        /*binding.plusButton.setOnClickListener{
            if(produtoSelecionado?.quantidade?.toInt() == 0){
                Toast.makeText(requireContext(),"Produto Indisponível", Toast.LENGTH_SHORT).show()

            }else if(contadorProdutos < produtoSelecionado?.quantidade?.toInt()!!){
                contadorProdutos++
                binding.textquantidade.setText("$contadorProdutos")

            }
        }
        binding.minusButton.setOnClickListener{

            if(produtoSelecionado?.quantidade?.toInt() == 0){
                Toast.makeText(requireContext(),"Produto Indisponível", Toast.LENGTH_SHORT).show()

            }else if(contadorProdutos <= 1){
                //mainViewModel.delay(500)
                findNavController().navigate(R.id.action_paginaDeDescricaoDoProdutoFragment_to_catalogo)


            }else{
                contadorProdutos--
                binding.textquantidade.setText("$contadorProdutos")
            }
        }

         */
        binding.buttonAdicionarOutroItem.setOnClickListener {
            findNavController().navigate(R.id.action_carrinho_to_catalogo)
        }
        return binding.root

    }

    fun abrirCarrinho() {
        findNavController().navigate(R.id.action_homepage_to_carrinho)

    }

}