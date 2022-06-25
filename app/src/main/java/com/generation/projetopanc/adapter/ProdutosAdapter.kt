package com.generation.projetopanc.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetopanc.MainViewModel
import com.generation.projetopanc.R
import com.generation.projetopanc.databinding.CardcatalogoLayoutBinding
import com.generation.projetopanc.model.Produtos

class ProdutosAdapter (
    val produtosClickListener: ProdutosClickListener,
    val mainViewModel: MainViewModel
        ): RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder> (){

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
        //holder.binding.textImagem.text = produtos.imagem
        holder.binding.textquantidade.text = produtos.quantidade
        holder.binding.textValor.text = produtos.valor
        holder.binding.textCategoria.text = produtos.categoria.descricao

        /*

        //CÓDIGO ANTIGO - VOU USAR PRA CRIAR A PDP

        holder.itemView.setOnClickListener{
            produtosClickListener.onProdutosClickListener(produtos)

        }

         */

        holder.binding.editButton.setOnClickListener{
            produtosClickListener.onProdutosClickListener(produtos)
        }



        when(produtos.nomeMarca){

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
        }

        if(produtos.quantidade.toInt() == 1){
            holder.binding.textqtd2.setText(" disponível)")
        }else if(produtos.quantidade.toInt() == 0){
            holder.binding.textqtd2.setText(" indisponível)")
            //holder.binding.textqtd2.setTextColor()
            holder.binding.textqtd2.setText(" disponíveis)")
        }

        when(produtos.categoria.descricao){

            "Troca" ->{holder.binding.categoriaIcon.setImageResource(R.drawable.ic_troca)}
            "Venda" ->{holder.binding.categoriaIcon.setImageResource(R.drawable.ic_venda)}
            "Doação" ->{holder.binding.categoriaIcon.setImageResource(R.drawable.ic_doacao)}

            else ->{}

        }

        //holder.binding.textImagem.setImageResource()




    }

    override fun getItemCount(): Int {
        return listProdutos.size
    }

    fun setList(list: List<Produtos>){

        listProdutos = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }



}