package com.generation.projetopanc.api

import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProdutos(
        @Body produtos: Produtos
    ): retrofit2.Response<Produtos>


    @GET("produtos")
    suspend fun listProdutos(): retrofit2.Response<List<Produtos>>

    @PUT("produtos")
    suspend fun updateProdutos(
        @Body produtos: Produtos
    ): retrofit2.Response<Produtos>

    @GET("produtos/nome-marca/{nomeMarca}")
    suspend fun searchDatabase(@Path("nomeMarca") nomeMarca: String): retrofit2.Response<List<Produtos>>






}