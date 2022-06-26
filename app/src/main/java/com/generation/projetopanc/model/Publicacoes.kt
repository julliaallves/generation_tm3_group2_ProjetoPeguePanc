package com.generation.projetopanc.model

data class Publicacoes (
    var id: Long,
    var postagem: String,
    var usuario: String,
    var compartilhamento: Int,
    var comentario: Int
        ){
}