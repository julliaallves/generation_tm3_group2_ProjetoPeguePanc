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
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class MainViewModel @Inject constructor(

    private  val repository: Repository

) : ViewModel() {

    var produtoSelecionado: Produtos? = null

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    private val _mySearchResponse =
        MutableLiveData<Response<List<Produtos>>>()

    val mySearchResponse: LiveData<Response<List<Produtos>>> =
        _mySearchResponse

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
                listProdutos()
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

    fun updateProdutos(produtos: Produtos){
        viewModelScope.launch {
            try {
                val response = repository.updateProdutos(produtos)
                listProdutos()
            }catch (e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun searchDatabase(search: String){
        viewModelScope.launch {
            try {
                val response = repository.searchDatabase(search)
                _mySearchResponse.value = response
            }catch (e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun deleteProdutos(id: Long){
        viewModelScope.launch {
            try{
                repository.deleteProdutos(id)
                listProdutos()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

}
    /*fun delay(time:Long){
    viewModelScope.launch {
        try {
            delay(time)

        } catch (e: Exception) {
            Log.d("Erro", e.message.toString())
        }
    }

     */

    /*fun searchDatabase(search: String): {
        viewModelScope.launch {
            try {
                val response = repository.searchDatabase(search)
                _mySearchResponse.value = response
                //listProdutos()

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }



     */

