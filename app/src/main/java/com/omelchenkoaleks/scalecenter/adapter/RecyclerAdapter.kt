package com.omelchenkoaleks.scalecenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.scalecenter.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item.view.*

class RecyclerAdapter(imageUrls: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var urls: MutableList<String> = imageUrls

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(urls[position]).into(holder.image)
    }

    override fun getItemCount(): Int = urls.size
}