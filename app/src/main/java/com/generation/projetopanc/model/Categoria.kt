package com.generation.projetopanc.model

data class Categoria (
    var id: Long,
    var descricao: String?,
    var produtos: List<Produtos>?
){

    override fun toString(): String {
        return descricao!! // !! indica que não pode ser null
    }
}