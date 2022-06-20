package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.ProdutosAdapter
import com.generation.projetopanc.databinding.FragmentCatalogoBinding
import com.generation.projetopanc.model.Produtos


class CatalogoFragment : Fragment() {

    private lateinit var binding: FragmentCatalogoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogoBinding.inflate(layoutInflater,container,false)


        /*val listProdutos = listOf(
            Produtos(
                "https://cdn.progresso.com.br/upload/dn_noticia/2012/06/4fe0763d9343b1ebc9c983ac44a4ecd4ad4360ce4f8c1.jpg",
                "Muda de Taioba",
                8.50,
                "Mudas de Taioba, ótimas para anemia!",
                25
            ),
            Produtos(
                "http://aptaregional.sp.gov.br/noticias/pesquisa-da-apta-mostra-potencial-de-cultivo-da-panc-major-gomes.html",
                "Maço de Majongome",
                2.50,
                "Maços de Manjongome frescos!",
                15
            ),
            Produtos(
                "https://araca.eco.br/wp-content/uploads/2020/11/20210125_113701-scaled.jpg",
                "Muda de Ora-pró-Nobis",
                7.50,
                "Mudas para replantiu em até 15 dias.",
                8
            ),
            Produtos(
                "https://i1.wp.com/files.agro20.com.br/uploads/2019/06/bertalha-1.jpg?resize=600%2C338&ssl=1",
                "Maço de Bertalha",
                5.00,
                "PANC que mais parece uma planta ornamental. Embeleze sua casa e forre seu estômago.",
                32
            ),
            Produtos(
                "https://medium.com/@hcpenna/jacatup%C3%A9-e-sua-hist%C3%B3ria-como-alimento-8ddbdf12b3ef",
                "Jacatupé / Kg",
                4.50,
                "PANC parecendo nabo",
                20
            ),
            Produtos(
                "https://a-static.mlcdn.com.br/1500x1500/flor-de-hibisco-naturais/apogeufilial/713d6d421a8a11ecaa834201ac185013/c8b1082c23936a8b9c41afffaee76f76.jpg",
                "Hibísco/Kg",
                15.00,
                "PANC ótima para chás e sucos",
                50
            ),
            Produtos(
                "https://i.pinimg.com/originals/0e/f5/34/0ef534d60fa362c83ef22101acd02d98.jpg",
                "Maço de Capeba",
                3.50,
                "PANC",
                100
            )
        )

         */

        //Configuração do RecyclerView
        val adapter = ProdutosAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        //adapter.setList()


        return binding.root

    }

}