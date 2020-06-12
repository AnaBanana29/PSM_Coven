package com.example.coven.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coven.R
import com.example.coven.models.HechizoModel
import kotlinx.android.synthetic.main.template_hechizos_item.view.*

class LibreriaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<HechizoModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HechizoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_hechizos_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HechizoViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(hechizoList: List<HechizoModel>) {
        items = hechizoList
    }

    class HechizoViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val hechizo_titulo = itemView.tv_hechizoTitulo
        val hechizo_usuario = itemView.tv_hechizoUsuario
        val hechizo_descripcion = itemView.tv_hechizoDescripcion
        val hechizo_likes = itemView.tv_hechizoLikes
        val hechizo_icon = itemView.iv_heart

        fun bind(hechizo : HechizoModel){
            hechizo_titulo.setText(hechizo.titulo)
            hechizo_usuario.setText(hechizo.usuario_nombre)
            hechizo_descripcion.setText(hechizo.descripcion)
            hechizo_likes.setText(hechizo.likes.toString())

            hechizo_icon.setOnClickListener{
                hechizo.likes ++
                hechizo_likes.setText(hechizo.likes.toString())
            }
        }


    }

    interface OnItemClickListener{
        fun onItemClick(hechizo: HechizoModel)
    }
}