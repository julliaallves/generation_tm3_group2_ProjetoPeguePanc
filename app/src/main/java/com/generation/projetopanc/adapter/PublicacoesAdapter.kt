package com.generation.projetopanc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.databinding.CardpublicacoesLayoutBinding
import com.generation.projetopanc.model.Publicacoes

class PublicacoesAdapter: RecyclerView.Adapter<PublicacoesAdapter.PublicacoesViewHolder>() {

    private var listPublicacoes = emptyList<Publicacoes>()

    class PublicacoesViewHolder(val binding: CardpublicacoesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicacoesViewHolder {
            return PublicacoesViewHolder(
                CardpublicacoesLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        override fun onBindViewHolder(holder: PublicacoesViewHolder, position: Int) {
            val publicacoes = listPublicacoes[position]

            holder.binding.textUsuario.text = publicacoes.usuario
            holder.binding.textDescricaoPost.text = publicacoes.postagem
            holder.binding.textComentarios.text = publicacoes.comentario.toString()
            holder.binding.textCompartilhamento.text = publicacoes.compartilhamento.toString()

        }

        override fun getItemCount(): Int {
            return listPublicacoes.size
        }

        fun setList(list: List<Publicacoes>) {
            listPublicacoes = list
            notifyDataSetChanged()
        }
    }
