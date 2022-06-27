package com.generation.projetopanc.repositorydao

import androidx.lifecycle.LiveData
import com.generation.projetopanc.data.db.entity.ProdutosCarrinhoEntity

interface ProdutosCarrinhoRepository {

    suspend fun insertProdutosCarrinho(nomeMarca: String, quantidade: Int, descricao: String, valor: String): Long

    suspend fun updateProdutosCarrinho(id: Long, nomeMarca: String, quantidade: Int, descricao: String, valor: String)

    suspend fun deleteProdutosCarrinho(id: Long)

    suspend fun deleteAllProdutosCarrinho()

    suspend fun getAllProdutosCarrinho(): LiveData<List<ProdutosCarrinhoEntity>>
}