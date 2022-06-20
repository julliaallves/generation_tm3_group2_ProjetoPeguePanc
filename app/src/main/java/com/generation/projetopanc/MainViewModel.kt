package com.generation.projetopanc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.projetopanc.api.Repository
import com.generation.projetopanc.model.Categoria
import com.generation.projetopanc.model.Produtos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private  val repository: Repository
) : ViewModel() {

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    private val _myprodutosResponse =
        MutableLiveData<Response<List<Produtos>>>()

    val myProdutosResponse: LiveData<Response<List<Produtos>>> =
        _myprodutosResponse

    init {
      //listCategoria()
    }
    //corrotina
    fun listCategoria(){
        viewModelScope.launch{
            try {

                val response = repository.listCategoria()
                _myCategoriaResponse.value = response

            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addProdutos(produtos: Produtos){
        viewModelScope.launch{
            try {
                repository.addProdutos(produtos)
            }catch (e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listProdutos(){
        viewModelScope.launch {
            try {
                val response = repository.listProdutos()
                _myprodutosResponse.value = response
            }catch (e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

}