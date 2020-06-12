package com.example.coven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coven.adapters.PaginaGrimorioAdapter
import com.example.coven.database.PaginaGrimorioDataSource
import com.example.coven.fragments.LibreriaAdapter
import com.example.coven.models.PaginaGrimorioModel
import kotlinx.android.synthetic.main.activity_grimorio.*
import kotlinx.android.synthetic.main.fragment_libreria.*

class GrimorioActivity : AppCompatActivity() {

    val dataSource = PaginaGrimorioDataSource(this)
    private lateinit var paginaGrimorioAdapter: PaginaGrimorioAdapter
    private var mPaginaGrimorioModel: MutableList<PaginaGrimorioModel> = mutableListOf<PaginaGrimorioModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grimorio)

        cv_AgregarPagina.setOnClickListener{
            val intent: Intent = Intent(this, AddPagGrimorioActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        initRecyclerView()
        addDataSet()
    }

    fun addDataSet() {
        val data = dataSource.selectPaginas
        paginaGrimorioAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        rv_paginasGrimorio.apply {
            layoutManager = LinearLayoutManager(this@GrimorioActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            paginaGrimorioAdapter = PaginaGrimorioAdapter()
            adapter = paginaGrimorioAdapter
        }
    }

}
