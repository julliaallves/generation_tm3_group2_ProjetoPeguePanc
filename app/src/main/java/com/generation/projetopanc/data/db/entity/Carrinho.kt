package com.generation.projetopanc.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.generation.projetopanc.model.Categoria

@Entity(tableName = "carrinho")
data class Carrinho(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nomeMarca: String,
    val quantidade: Int,
    val descricao: String,
    val valor: String

)
