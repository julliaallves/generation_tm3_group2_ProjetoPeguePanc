package com.generation.projetopanc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.projetopanc.adapter.PublicacoesAdapter
import com.generation.projetopanc.databinding.FragmentPublicacoesBinding
import com.generation.projetopanc.model.Publicacoes

class PublicacoesFragment : Fragment() {

    private lateinit var binding: FragmentPublicacoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPublicacoesBinding.inflate(layoutInflater,container, false)

        val listPublicacoes = listOf(
            Publicacoes(
                1,
                "Acabei de plantar uma muda de beldroegão que troquei por umas folhas de" +
                        " taioba nesse site!",
                "Renato dos Santos",
                1,
                3

                ), Publicacoes(
                2,
                "A taioba me lembra a minha infância, quando eu ia na chácara do meu tio" +
                        " e ele sempre fazia salada com folha dela. Tinham muitas folhas enormes" +
                        "no jardim, e ele aproveitava cada pedaço. Nunca vi ninguem doente na " +
                        "familia dele, não conheço sobre panc's mas assim que descobri que já" +
                        " comi algumas, tive interesse em conhecer mais.",
                "Lourdes Pereira",
                2,
                1
            ), Publicacoes(
                3,
                "Esse aplicativo é muito legal! Nunca tinha visto vendendo hibisco em nenhum " +
                        "lugar. Sempre gostei de fazer chá e comer as folhas direto do pé, mas depois " +
                        "que mudei pra um apartamento em São Paulo, nunca mais comi. Pra quem nunca comeu," +
                        " saiba que é delicioso!!!!!!!",
                "Leticia do Carmo",
                1,
                5
            ), Publicacoes(
                4,
                "Meu chá favorito sempre foi de Hibisco, mas eu sempre comprava desidratado. " +
                        " Descobri que tinha um pé de hibisco na casa da minha avó quando conheci mais " +
                        "sobre as pancs. Muito bom saber as plantas ao nosso redor que podemos usar",
                "Victor Damião",
                18,
                25
            ), Publicacoes(
                5,
                "Vou apresentar uma receita de Geleia de flores de malvavisco." +
                        " Ingredientes\n" +
                        "\n" +
                        "500g de flores de malvavisco (cerca de 1 sacola de supermercado)\n" +
                        "\n" +
                        "1 xícara de chá de água\n" +
                        "\n" +
                        "1 xícara de chá de açúcar demerara ou cristal\n" +
                        "\n" +
                        "Suco de 1 limão\n" +
                        "\n" +
                        "Modo de preparo\n" +
                        "\n" +
                        "Colha as flores e retire o cálice verde. Higienize as pétalas e bata no " +
                        "liquidificador com água. Coloque em uma panela com o açúcar e deixe apurar" +
                        " em fogo baixo. Mexa de vez em quando e, quando estiver engrossando, " +
                        "adicione o suco do limão, desligue o fogo e deixe esfriar. Coloque em" +
                        " vidros limpos e com tampa e guarde na geladeira.",
                "Aires Mariga",
                1,
                3
            ), Publicacoes(
                6,
                "Olá, essa é minha primeira publicação no aplicativo! Gostaria de falar um " +
                        "pouco de uma PANC que utilizo bastante no meu dia a dia. \n" +
                        "Tenho meu pé de Ora pro nobis aqui em casa, e ele me ajudou bastante " +
                        "a me recuperar dos sintomas pós covid graças ao quanto ele ajuda no " +
                        "sistema imunológico.\nUma amiga minha pediu uma muda de ora pro nobis quando" +
                        " estava querendo fazer uma mudança de hábitos alimentares, e se tornar " +
                        "vegana, e me disse que é uma planta que é uma excelente fonte de" +
                        " proteínas, e fui experimentar fazer um refogado com ela. " +
                        "A ora pro nobis faz um tipo de baba parecida com a do quiabo, e fica muito" +
                        " gostoso de comer junto com frango se não for vegano.\n" +
                        "Obrigada por lerem meu relato sobre essa planta maravilhosa!",
                "Lizandra Ferrari",
                6,
                2,
            )
        )
        //meter um when pro id pra usar a imagem (tem na aba de produtos assim) use 1000x1000

        val adapter = PublicacoesAdapter()
        binding.recyclerPublicacoes.layoutManager = LinearLayoutManager(context)
        binding.recyclerPublicacoes.adapter = adapter
        binding.recyclerPublicacoes.setHasFixedSize(true)

        adapter.setList(listPublicacoes)

        return binding.root
    }

}