package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.CarrinhoAdapter
import com.generation.projetopanc.databinding.FragmentCarrinhoBinding
import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos

class CarrinhoFragment : Fragment() {

    private lateinit var binding: FragmentCarrinhoBinding
    private val mainviewmodel : MainViewModel by activityViewModels()
    private var listCategoria = emptyList<Produtos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrinhoBinding.inflate(layoutInflater, container, false)
        mainviewmodel.listCategoria()

        val listCarrinho = listOf(
            Produtos(
                1,
                "Hibisco",
                "Vendo Hibisco",
                "",
                "2",
                "13",
                Categoria(1, "Venda", listCategoria
                )
            ),
                Produtos(
                    2,
                    "Taioba",
                    "Vendo Taioba",
                    "",
                    "1",
                    "2",
                    Categoria(2, "Venda", listCategoria
                    )
            )
        )

        val adapter = CarrinhoAdapter()
        binding.recyclerCarrinho.layoutManager = LinearLayoutManager(context)
        binding.recyclerCarrinho.adapter = adapter
        binding.recyclerCarrinho.setHasFixedSize(true)

        adapter.setList(listCarrinho)

        return binding.root

    }

    fun abrirCarrinho() {
        findNavController().navigate(R.id.action_homepage_to_carrinho)

    }

}