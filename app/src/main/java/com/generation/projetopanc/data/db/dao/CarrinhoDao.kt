package com.generation.projetopanc.data.db.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import com.generation.projetopanc.data.db.entity.Carrinho


@Dao
interface CarrinhoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(carrinho:Carrinho)

    @Update
    fun update(carrinho: Carrinho)

    @Query("DELETE FROM carrinho WHERE id = :id")
    fun delete(id: Long)

    @Query("DELETE FROM carrinho")
    fun deleteAll()

    @Query("SELECT * FROM carrinho ORDER BY id ASC")
    fun getAll(): LiveData<List<Carrinho>>

}