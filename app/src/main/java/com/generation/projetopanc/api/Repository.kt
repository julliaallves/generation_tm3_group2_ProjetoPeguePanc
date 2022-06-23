package com.generation.projetopanc.api

import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos
import retrofit2.Response


class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitObject.api.listCategoria()
    }

    suspend fun addProdutos(produtos: Produtos): Response<Produtos>{
        return RetrofitObject.api.addProdutos(produtos)
    }

    suspend fun listProdutos(): Response<List<Produtos>>{
        return RetrofitObject.api.listProdutos()
    }

    suspend fun updateProdutos(produtos: Produtos): Response<Produtos>{
        return RetrofitObject.api.updateProdutos(produtos)
    }
}