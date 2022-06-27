package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.databinding.FragmentPaginaDeDescricaoDoProdutoBinding
import com.generation.projetopanc.model.Produtos
import kotlinx.coroutines.delay

class PaginaDeDescricaoDoProdutoFragment : Fragment() {

    private lateinit var binding: FragmentPaginaDeDescricaoDoProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produtos? = null
    private var contadorProdutos: Int = 1

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
        when(produtoSelecionado?.nomeMarca){

            "Taioba" ->{binding.imagemProduto.setImageResource(R.drawable.taioba)}
            "Ora-pro-nóbis" ->{binding.imagemProduto.setImageResource(R.drawable.orapronobis)}
            "Feijão-espada" ->{binding.imagemProduto.setImageResource(R.drawable.feijaoespada)}
            "Alho-silvestre" ->{binding.imagemProduto.setImageResource(R.drawable.alhosilvestre)}
            "Feijoa" ->{binding.imagemProduto.setImageResource(R.drawable.feijoa)}
            "Mangará" ->{binding.imagemProduto.setImageResource(R.drawable.mangara)}
            "Melão-andino" ->{binding.imagemProduto.setImageResource(R.drawable.melaoandino)}
            "Peixinho-da-horta" ->{binding.imagemProduto.setImageResource(R.drawable.peixinhodahorta)}
            "Mentruz" ->{binding.imagemProduto.setImageResource(R.drawable.mentruz)}
            "Arumbeva" ->{binding.imagemProduto.setImageResource(R.drawable.arumbeva)}
            //"Begônia" ->{binding.imagemProduto.setImageResource(R.drawable.begonia)}
            "Urtigão" ->{binding.imagemProduto.setImageResource(R.drawable.urtigao)}
            "Gabiroba" ->{binding.imagemProduto.setImageResource(R.drawable.gabiroba)}
            "Semente de Baru" ->{binding.imagemProduto.setImageResource(R.drawable.sementedebaru)}
            "Trevo" ->{binding.imagemProduto.setImageResource(R.drawable.trevo)}
            "Hibisco" ->{binding.imagemProduto.setImageResource(R.drawable.hibisco)}
            "Celósia" ->{binding.imagemProduto.setImageResource(R.drawable.celosia)}
            "Trapoeraba" ->{binding.imagemProduto.setImageResource(R.drawable.trapoeraba)}
            "Araruta" ->{binding.imagemProduto.setImageResource(R.drawable.araruta)}
            "Pequi" ->{binding.imagemProduto.setImageResource(R.drawable.pequi)}
            "Jaca Verde" ->{binding.imagemProduto.setImageResource(R.drawable.jaca)}
            "Fruta-pão" ->{binding.imagemProduto.setImageResource(R.drawable.frutapaum)}


            else ->{binding.imagemProduto.setImageResource(R.drawable.imagem)}
        }

        //produtoSelecionado.quantidade
        binding.plusButton.setOnClickListener{
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

        return binding.root
    }


    private fun carregarDados() {
        produtoSelecionado = mainViewModel.produtoSelecionado
        if (produtoSelecionado != null) {
            binding.textNome.setText(produtoSelecionado?.nomeMarca)
            binding.textDescricao.setText(produtoSelecionado?.descricao)
            binding.textValor.setText(produtoSelecionado?.valor)
            //binding..text = produtos.categoria.descricao
            mainViewModel.produtoSelecionado = null
            if(produtoSelecionado?.quantidade?.toInt() != 0){
                binding.textquantidade.setText("1")
            }


        }
    }

}
