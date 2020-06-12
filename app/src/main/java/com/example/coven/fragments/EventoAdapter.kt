package com.example.coven.fragments

import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.coven.DetallesEventoActivity
import com.example.coven.R
import com.example.coven.models.EventoModel
import kotlinx.android.synthetic.main.template_eventos_item.view.*

class EventoAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<EventoModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EventoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_eventos_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EventoViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(eventoList: List<EventoModel>?) {
        items = eventoList!!
    }

    class EventoViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val evento_fecha : TextView = itemView.tv_eventoFecha
        val evento_titulo : TextView = itemView.tv_eventoTitulo
        val evento_descripcion : TextView = itemView.tv_eventoDescripcion
        val evento_lugar : TextView = itemView.tv_eventoLugar

        fun bind(eventoModel: EventoModel){
            evento_fecha.setText(eventoModel.fecha)
            evento_titulo.setText(eventoModel.titulo)
            evento_descripcion.setText(eventoModel.descripcion)
            evento_lugar.setText(eventoModel.nombreLugar)

            itemView.setOnClickListener{
                var intent = Intent(this.itemView.context, DetallesEventoActivity::class.java)
                intent.putExtra("Evento", eventoModel)
                itemView.context.startActivity(intent)
            }

        }

    }

    interface OnItemClickListener{
        fun onItemClick(evento: EventoModel)
    }

}