package com.generation.projetopanc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.CarrinhoViewModel
import com.generation.projetopanc.MainViewModel
import com.generation.projetopanc.R
import com.generation.projetopanc.data.db.entity.Carrinho
import com.generation.projetopanc.databinding.CardcarrinhoLayoutBinding
import com.generation.projetopanc.model.Produtos

class CarrinhoAdapter(
    val carrinhoViewModel: CarrinhoViewModel,
    val mainViewModel: MainViewModel
): RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>(){

    private var listCarrinho = emptyList<Carrinho>()
    private var listProduto = emptyList<Produtos>()
    var total1 = 0.0

    class CarrinhoViewHolder(val binding: CardcarrinhoLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        return CarrinhoViewHolder(
            CardcarrinhoLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false

            )
        )
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val carrinho = listCarrinho[position]

        holder.binding.textNome.text = carrinho.nomeMarca
        holder.binding.textValor.text = carrinho.valor
        holder.binding.textquantidade.text = carrinho.quantidade.toString()
        holder.binding.textDescricao.text = carrinho.descricao


        //Deletar item do carrinho
        holder.binding.removerButton.setOnClickListener{
            deleteCarrinho(carrinho.id)
        }


        when(carrinho.nomeMarca){

            "Taioba" ->{holder.binding.textImagem.setImageResource(R.drawable.taioba)}
            "Ora-pro-nóbis" ->{holder.binding.textImagem.setImageResource(R.drawable.orapronobis)}
            "Feijão-espada" ->{holder.binding.textImagem.setImageResource(R.drawable.feijaoespada)}
            "Alho-silvestre" ->{holder.binding.textImagem.setImageResource(R.drawable.alhosilvestre)}
            "Feijoa" ->{holder.binding.textImagem.setImageResource(R.drawable.feijoa)}
            "Mangará" ->{holder.binding.textImagem.setImageResource(R.drawable.mangara)}
            "Melão-andino" ->{holder.binding.textImagem.setImageResource(R.drawable.melaoandino)}
            "Peixinho-da-horta" ->{holder.binding.textImagem.setImageResource(R.drawable.peixinhodahorta)}
            "Mentruz" ->{holder.binding.textImagem.setImageResource(R.drawable.mentruz)}
            "Arumbeva" ->{holder.binding.textImagem.setImageResource(R.drawable.arumbeva)}
            //"Begônia" ->{holder.binding.textImagem.setImageResource(R.drawable.begonia)}
            "Urtigão" ->{holder.binding.textImagem.setImageResource(R.drawable.urtigao)}
            "Gabiroba" ->{holder.binding.textImagem.setImageResource(R.drawable.gabiroba)}
            "Semente de Baru" ->{holder.binding.textImagem.setImageResource(R.drawable.sementedebaru)}
            "Trevo" ->{holder.binding.textImagem.setImageResource(R.drawable.trevo)}
            "Hibisco" ->{holder.binding.textImagem.setImageResource(R.drawable.hibisco)}
            "Celósia" ->{holder.binding.textImagem.setImageResource(R.drawable.celosia)}
            "Trapoeraba" ->{holder.binding.textImagem.setImageResource(R.drawable.trapoeraba)}
            "Araruta" ->{holder.binding.textImagem.setImageResource(R.drawable.araruta)}
            "Pequi" ->{holder.binding.textImagem.setImageResource(R.drawable.pequi)}
            "Jaca Verde" ->{holder.binding.textImagem.setImageResource(R.drawable.jaca)}
            "Fruta-pão" ->{holder.binding.textImagem.setImageResource(R.drawable.frutapaum)}


            else ->{holder.binding.textImagem.setImageResource(R.drawable.imagem)}
            //no lugar disso talvez por o glider.
        }

    }
    override fun getItemCount(): Int {
        return listCarrinho.size
    }
    fun setList(list: List<Carrinho>) {
        listCarrinho = list
        notifyDataSetChanged()
    }
    private fun deleteCarrinho(id: Long){
        carrinhoViewModel.deleteCarrinho(id)
    }
    fun setListProdutos(list:List<Produtos>){
        listProduto = list
    }
    fun setTotal(list:List<Carrinho>){
        setList(list)
        var total:Double = 0.0
        listCarrinho.forEach{
            total += it.valor.toDouble() * it.quantidade.toDouble()
        }
        carrinhoViewModel.total = total
        total1 = total
    }





}

