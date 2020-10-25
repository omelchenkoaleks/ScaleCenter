package com.omelchenkoaleks.scalecenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.scalecenter.adapter.RecyclerAdapter
import com.omelchenkoaleks.scalecenter.layout_manager.ScaleCenterItemLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = recycler_view
//        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        val scaleCenterItemLayoutManager = ScaleCenterItemLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerView.layoutManager = scaleCenterItemLayoutManager
        generateData()
    }

    private fun generateData() {
        val random = Random()
        val imageUrls = ArrayList<String>()
        for (i in 0..100) {
            imageUrls.add("https://picsum.photos/150/150?random=" + random.nextInt())
        }
        val adapter = RecyclerAdapter(imageUrls)
        mRecyclerView.adapter = adapter
    }
}