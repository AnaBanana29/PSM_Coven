package com.example.coven.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coven.*

import com.example.coven.models.EventoModel
import kotlinx.android.synthetic.main.fragment_eventos.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var eventoAdapter: EventoAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [EventosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventosFragment : Fragment(), EventoAdapter.OnItemClickListener {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eventos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        addDataSet()

        cv_AgregarEvento.setOnClickListener{
            val intent: Intent = Intent(context, AgregarEventoActivity::class.java)
            startActivity(intent)
        }

        rv_Eventos.setOnClickListener{
            val intent: Intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun addDataSet() {

        val data = com.example.coven.models.DataSource.createDataSetEvento()
        eventoAdapter.submitList(data)



    }

    private fun initRecyclerView(){
        val data = com.example.coven.models.DataSource.createDataSetEvento()
        rv_Eventos.apply {
            layoutManager = LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            eventoAdapter = EventoAdapter()
            adapter = eventoAdapter
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EventosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(item: EventoModel) {
        var intent = Intent(context, DetallesEventoActivity::class.java)
        intent.putExtra("Evento", item)
    }
}
