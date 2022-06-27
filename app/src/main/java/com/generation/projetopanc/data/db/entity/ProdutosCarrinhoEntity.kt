package com.generation.projetopanc.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProdutosCarrinho")
data class ProdutosCarrinhoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nomeMarca: String,
    val quantidade: Int,
    val descricao: String,
    val valor: String
)
