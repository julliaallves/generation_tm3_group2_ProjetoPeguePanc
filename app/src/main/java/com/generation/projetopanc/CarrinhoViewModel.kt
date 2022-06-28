package com.generation.projetopanc

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.generation.projetopanc.data.db.CarrinhoDatabase
import com.generation.projetopanc.data.db.entity.Carrinho
import com.generation.projetopanc.repositorydao.CarrinhoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarrinhoViewModel(application: Application) : AndroidViewModel(application) {

    val carrinhoRepository: CarrinhoRepository
    val getAllCarrinho: LiveData<List<Carrinho>>

    init {
        val carrinhoDao = CarrinhoDatabase.getDatabase(application).carrinhoDao()
        carrinhoRepository = CarrinhoRepository(carrinhoDao)
        getAllCarrinho = carrinhoRepository.getAllCarrinho

    }



    fun addCarrinho(carrinho: Carrinho){
        viewModelScope.launch(Dispatchers.IO) {
            carrinhoRepository.addCarrinho(carrinho)
        }
    }

    fun updateCarrinho(carrinho: Carrinho){
        viewModelScope.launch(Dispatchers.IO){
            carrinhoRepository.updateCarrinho(carrinho)
        }
    }
    fun deleteCarrinho(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            carrinhoRepository.deleteCarrinho(id)
        }
    }
    fun deleteAllCarrinho(){
        viewModelScope.launch(Dispatchers.IO){
            carrinhoRepository.deleteAllCarrinho()
        }
    }
}