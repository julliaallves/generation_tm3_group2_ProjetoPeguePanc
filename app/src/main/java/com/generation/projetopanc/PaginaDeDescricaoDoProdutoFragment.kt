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
import com.generation.projetopanc.data.db.entity.Carrinho
import com.generation.projetopanc.databinding.FragmentPaginaDeDescricaoDoProdutoBinding
import com.generation.projetopanc.model.Produtos

class PaginaDeDescricaoDoProdutoFragment : Fragment() {

    private lateinit var binding: FragmentPaginaDeDescricaoDoProdutoBinding
    private lateinit var carrinhoViewModel: CarrinhoViewModel
    private val mainViewModel: MainViewModel by activityViewModels()
    private var produtoSelecionado: Produtos? = null
    private var contadorProdutos: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaginaDeDescricaoDoProdutoBinding.inflate(layoutInflater,container,false)

        carrinhoViewModel = ViewModelProvider(this).get(CarrinhoViewModel::class.java)

        carregarDados()



        binding.voltarButton.setOnClickListener{
            findNavController().navigate(R.id.action_paginaDeDescricaoDoProdutoFragment_to_catalogo)
        }

        binding.buttonComprar.setOnClickListener{
            if(produtoSelecionado?.quantidade?.toInt() == 0){
                Toast.makeText(requireContext(),"Produto Indisponível", Toast.LENGTH_SHORT).show()
            }else inserirNoBanco()
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

    fun verificarCampos(
            nomeMarca: String,
            quantidade: Int,
            descricao: String,
            valor: String
        ): Boolean {
            return !(nomeMarca == "" || quantidade == 0 || descricao =="" || valor == "")
    }

    fun inserirNoBanco(){

        val nomeMarca = produtoSelecionado?.nomeMarca.toString()
        val quantidade = contadorProdutos
        val descricao = produtoSelecionado?.descricao.toString()
        val valor = produtoSelecionado?.valor.toString()


        if(verificarCampos(nomeMarca, quantidade, descricao, valor)){
            var produtoCarrinho = Carrinho(0, nomeMarca, quantidade, descricao, valor)
            carrinhoViewModel.addCarrinho(produtoCarrinho)
            Toast.makeText(context, "Produto Adicionado!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_paginaDeDescricaoDoProdutoFragment_to_carrinho)
        }else{
            Toast.makeText(context, "Algo deu errado...", Toast.LENGTH_SHORT).show()
        }

    }


}
