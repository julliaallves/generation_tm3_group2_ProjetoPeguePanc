package com.generation.projetopanc.repositorydao

import androidx.lifecycle.LiveData
import com.generation.projetopanc.data.db.dao.ProdutosCarrinhoDao
import com.generation.projetopanc.data.db.entity.ProdutosCarrinhoEntity

class DatabaseDataSource(
    private val produtosCarrinhoDao: ProdutosCarrinhoDao
) : ProdutosCarrinhoRepository {
    override suspend fun insertProdutosCarrinho(
        nomeMarca: String,
        quantidade: Int,
        descricao: String,
        valor: String
    ): Long {
        val produtosCarrinho = ProdutosCarrinhoEntity(
            nomeMarca = nomeMarca,
            quantidade = quantidade,
            descricao = descricao,
            valor = valor
        )

        return produtosCarrinhoDao.insert(produtosCarrinho)
    }

    override suspend fun updateProdutosCarrinho(
        id: Long,
        nomeMarca: String,
        quantidade: Int,
        descricao: String,
        valor: String
    ) {
        val produtosCarrinho = ProdutosCarrinhoEntity(
            id = id,
            nomeMarca = nomeMarca,
            quantidade = quantidade,
            descricao = descricao,
            valor = valor
        )

        return produtosCarrinhoDao.update(produtosCarrinho)
    }

    override suspend fun deleteProdutosCarrinho(id: Long) {
        return produtosCarrinhoDao.delete(id)
    }

    override suspend fun deleteAllProdutosCarrinho() {
        return produtosCarrinhoDao.deleteAll()
    }

    override suspend fun getAllProdutosCarrinho(): LiveData<List<ProdutosCarrinhoEntity>> {
        return produtosCarrinhoDao.getAll()
    }
}