package com.generation.projetopanc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.databinding.CardcarrinhoLayoutBinding
import com.generation.projetopanc.model.Produtos

class CarrinhoAdapter: RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    private var listCarrinho = emptyList<Produtos>()

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
        holder.binding.textquantidade.text = carrinho.quantidade

    }
    override fun getItemCount(): Int {
        return listCarrinho.size
    }
    fun setList(list: List<Produtos>) {
        listCarrinho = list
        notifyDataSetChanged()
    }
}

