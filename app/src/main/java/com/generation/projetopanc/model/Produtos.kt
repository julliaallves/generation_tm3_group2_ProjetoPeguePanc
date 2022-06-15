package com.generation.projetopanc.model

data class Produtos (
    var id: Long,
    var nomeMarca: String,
    var descricao: String,
    var imagem: String,
    var quantidade: String,
    var valor: String,
    var categoria: Categoria
    ){
}