package com.generation.projetopanc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.databinding.CardcatalogoLayoutBinding
import com.generation.projetopanc.model.Produtos

class ProdutosAdapter : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder> (){

    private var listProdutos = emptyList<Produtos>()

    class ProdutosViewHolder (val binding: CardcatalogoLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        return ProdutosViewHolder(CardcatalogoLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        var produtos = listProdutos[position]

        holder.binding.textNome.text = produtos.nomeMarca
        holder.binding.textDescricao.text = produtos.descricao
        holder.binding.textImagem.text = produtos.imagem
        holder.binding.textquantidade.text = produtos.quantidade.toString()
        holder.binding.textValor.text = produtos.valor
        //holder.binding.textCategoria.text = produtos.categoria.descricao
    }

    override fun getItemCount(): Int {
        return listProdutos.size
    }

    fun setList(list: List<Produtos>){

        listProdutos = list
        notifyDataSetChanged()
    }

}