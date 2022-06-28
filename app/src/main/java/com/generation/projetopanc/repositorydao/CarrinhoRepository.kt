package com.generation.projetopanc.repositorydao

import com.generation.projetopanc.data.db.dao.CarrinhoDao
import com.generation.projetopanc.data.db.entity.Carrinho

class CarrinhoRepository (private val carrinhoDao: CarrinhoDao) {

    fun addCarrinho(carrinho: Carrinho){
        carrinhoDao.insert(carrinho)
        }

    fun updateCarrinho(carrinho: Carrinho){
        carrinhoDao.update(carrinho)
    }
    fun deleteCarrinho(id: Long){
        carrinhoDao.delete(id)
    }
    fun deleteAllCarrinho(){
        carrinhoDao.deleteAll()
    }

    val getAllCarrinho = carrinhoDao.getAll()


}