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
                "Olá, essa é minha primeira publicação no aplicativo! Gostaria de falar um " +
                        "pouco de uma PANC que utilizo bastante no meu dia a dia." +
                        "Tenho meu pé de Ora pro nobis aqui em casa, e ele me ajudou bastante" +
                        "a me recuperar dos sintomas pós covid, graças ao quanto ele ajuda no" +
                        "sistema imunológico. " +
                        "Uma amiga minha pediu uma muda de ora pro nobis inclusive, e contou" +
                        "que estava querendo fazer uma mudança de hábitos alimentares, e se tornar" +
                        "vegana. Com isso descobri que é uma planta que é uma excelente fonte de" +
                        "proteínas, e fui experimentar fazer um refogado com ela." +
                        "A ora pro nobis faz um tipo de baba parecida com a do quiabo, e fica muito" +
                        "gostoso de comer junto com frango. " +
                        "Obrigada por lerem meu relato sobre essa planta maravilhosa!",
                "Lizandra Ferrari",
                6,
                2,

                ), Publicacoes(
                2,
                "A taioba me lembra a minha infância, quando eu ia na chácara do meu tio" +
                        "e ele sempre fazia salada com folha dela. Tinham muitas folhas enormes" +
                        "no jardim, e ele aproveitava cada pedaço. Nunca vi ninguem doente na " +
                        "familia dele, não conheço sobre panc's mas assim que descobri que já" +
                        "comi algumas, tive interesse em conhecer mais.",
                "Lourdes Pereira",
                2,
                1
            ), Publicacoes(
                3,
                "Esse aplicativo é muito legal! Nunca tinha visto vendendo hibisco em nenhum" +
                        "lugar. Sempre gostei de fazer chá e comer as folhas direto do pé, mas depois" +
                        "que mudei pra um apartamento em São Paulo, nunca mais comi. Pra quem nunca comeu," +
                        "saiba que é delicioso!!!!!!!",
                "Leticia do Carmo",
                1,
                5
            ), Publicacoes(
                4,
                "Meu chá favorito sempre foi de Hibisco, mas eu sempre comprava desidratado." +
                        "Descobri que tinha um pé de hibisco na casa da minha avó quando conheci mais " +
                        "sobre as pancs. Muito bom saber as plantas ao nosso redor que podemos usar",
                "Victor Damião",
                18,
                25
            )
        )

        val adapter = PublicacoesAdapter()
        binding.recyclerPublicacoes.layoutManager = LinearLayoutManager(context)
        binding.recyclerPublicacoes.adapter = adapter
        binding.recyclerPublicacoes.setHasFixedSize(true)

        adapter.setList(listPublicacoes)

        return binding.root
    }

}