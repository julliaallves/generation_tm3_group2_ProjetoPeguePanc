package com.generation.projetopanc

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.ProdutosAdapter
import com.generation.projetopanc.adapter.ProdutosClickListener
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.model.Produtos

import java.util.*


class CatalogoFragment : Fragment(), ProdutosClickListener, SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentCatalogoBinding
    private val mainviewmodel : MainViewModel by activityViewModels()
    //Coloquei o adapter iniciando bylazy
    private val adapter: ProdutosAdapter by lazy {
        ProdutosAdapter(this, mainviewmodel, requireContext())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogoBinding.inflate(layoutInflater,container,false)
        mainviewmodel.listProdutos()



        //Configuração do RecyclerView

        binding.recyclerProduto.layoutManager = GridLayoutManager(context,2)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        setAdapter()



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onProdutosClickListener(produto: Produtos) {
        mainviewmodel.produtoSelecionado = produto
        findNavController().navigate(R.id.action_catalogo_to_novoProduto)

    }

    override fun onProdutosCLickListenerOpenPdp(produto: Produtos) {
        mainviewmodel.produtoSelecionado = produto
        findNavController().navigate(R.id.action_catalogo_to_paginaDeDescricaoDoProdutoFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menu != null){
            inflater.inflate(R.menu.toolbar_menu,menu)

            val search = menu?.findItem(R.id.app_bar_search)
            val searchView = search?.actionView as? SearchView
            searchView?.isSubmitButtonEnabled =true
            searchView?.setOnQueryTextListener(this)

        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true

            }
            //else -> super.onOptionsItemSelected(item)




    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null && query != ""){
            searchDatabase(query)
        }else{
            setAdapter()
        }

        return true

    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null && query!= ""){
            searchDatabase(query)
        }else{
            setAdapter()
        }
        return true
    }

    private fun searchDatabase(query: String){
        val searchQuery = "%$query%"
        mainviewmodel.searchDatabase(query)
        mainviewmodel.mySearchResponse.observe(viewLifecycleOwner){
                response -> if(response.body() != null){
            adapter.setList(response.body()!!)

        }

        }

    }

    private fun setAdapter(){
        mainviewmodel.myProdutosResponse.observe(viewLifecycleOwner){
                response -> if(response.body() != null){
            adapter.setList(response.body()!!)
            }

        }
    }

}

