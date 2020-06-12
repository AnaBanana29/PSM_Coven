package com.example.coven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coven.adapters.PaginaGrimorioAdapter
import com.example.coven.fragments.LibreriaAdapter
import kotlinx.android.synthetic.main.activity_grimorio.*
import kotlinx.android.synthetic.main.fragment_libreria.*

class GrimorioActivity : AppCompatActivity() {

    private lateinit var paginaGrimorioAdapter: PaginaGrimorioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grimorio)

        initRecyclerView()
        addDataSet()

    }

    fun addDataSet() {
        val data = com.example.coven.models.DataSource.createDataSetPaginarimorio()
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
