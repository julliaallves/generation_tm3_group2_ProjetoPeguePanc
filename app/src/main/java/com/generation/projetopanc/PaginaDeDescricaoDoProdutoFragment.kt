package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.databinding.FragmentPaginaDeDescricaoDoProdutoBinding
import com.generation.projetopanc.model.Produtos

class PaginaDeDescricaoDoProdutoFragment : Fragment() {

    private lateinit var binding: FragmentPaginaDeDescricaoDoProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produtos? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaginaDeDescricaoDoProdutoBinding.inflate(layoutInflater,container,false)

        carregarDados()

        binding.voltarButton.setOnClickListener{
            findNavController().navigate(R.id.action_paginaDeDescricaoDoProdutoFragment_to_catalogo)
        }

        binding.buttonComprar.setOnClickListener{
            findNavController().navigate(R.id.action_paginaDeDescricaoDoProdutoFragment_to_carrinho)
        }

        return binding.root
    }


    private fun carregarDados() {
        produtoSelecionado = mainViewModel.produtoSelecionado
        if (produtoSelecionado != null) {
            //binding.editTextNomeProd.setText(produtoSelecionado?.nomeMarca)
            //binding.editTextDescricao.setText(produtoSelecionado?.descricao)
            //binding.editTextValorProd.setText(produtoSelecionado?.valor)
            //binding.editTextQuantidade.setText(produtoSelecionado?.quantidade)
            //mainViewModel.produtoSelecionado = null
            //binding.textCategoria.text = produtos.categoria.descricao

        }
    }

}
