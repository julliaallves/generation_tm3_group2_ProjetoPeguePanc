package com.generation.projetopanc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.databinding.CardcatalogoLayoutBinding
import com.generation.projetopanc.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> (){
    var listTarefa = emptyList<Tarefa>()
    class TarefaViewHolder (val binding: CardcatalogoLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardcatalogoLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        var tarefa = listTarefa[position]

        holder.binding.textImagem.text = tarefa.imagem
        holder.binding.textNome.text = tarefa.descricao
        holder.binding.textValor.text = tarefa.precoProd.toString()
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textquantidade.text = tarefa.quantidade.toString()
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){

        listTarefa = list
        notifyDataSetChanged()


    }

}