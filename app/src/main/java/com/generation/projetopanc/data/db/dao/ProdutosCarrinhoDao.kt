package com.generation.projetopanc.data.db.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.generation.projetopanc.data.db.entity.ProdutosCarrinhoEntity


@Dao
interface ProdutosCarrinhoDao {
    @Insert
    suspend fun insert(produtosCarrinho:ProdutosCarrinhoEntity): Long

    @Update
    suspend fun update(produtosCarrinho: ProdutosCarrinhoEntity)

    @Query("DELETE FROM produtosCarrinho WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM produtosCarrinho")
    suspend fun deleteAll()

    @Query("SELECT * FROM produtosCarrinho")
    fun getAll(): LiveData<List<ProdutosCarrinhoEntity>>

}