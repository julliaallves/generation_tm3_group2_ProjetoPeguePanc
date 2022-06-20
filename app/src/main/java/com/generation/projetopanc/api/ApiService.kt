package com.generation.projetopanc.api

import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProdutos(
        @Body produtos: Produtos
    ): retrofit2.Response<Produtos>


    @GET("produtos")
    suspend fun listProdutos(): retrofit2.Response<List<Produtos>>

}