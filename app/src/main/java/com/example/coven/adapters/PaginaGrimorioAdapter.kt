package com.example.coven.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coven.R
import com.example.coven.models.PaginaGrimorioModel
import kotlinx.android.synthetic.main.template_pagina_grimorio_item.view.*

class PaginaGrimorioAdapter():
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<PaginaGrimorioModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PaginaGrimorioViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_pagina_grimorio_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PaginaGrimorioViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(paginaGrimorioList: List<PaginaGrimorioModel>?) {
        items = paginaGrimorioList!!
    }

    class PaginaGrimorioViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val pagina_titulo : TextView = itemView.tv_paginaTitulo
        val pagina_contenido : TextView = itemView.tv_paginaContenido
        val pagina_paginaNumero : TextView = itemView.tv_paginaNumero

        fun bind(paginaGrimorioModel: PaginaGrimorioModel){

            pagina_titulo.setText(paginaGrimorioModel.titulo)
            pagina_contenido.setText(paginaGrimorioModel.contenido)
            pagina_paginaNumero.setText(paginaGrimorioModel.id_Pagina.toString())

        }

    }
}