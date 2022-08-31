package com.example.firect_direct_from_farm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

 class MyChildAdapterCategory(var arrayy:MutableList<Category>, var con: Context) :
    RecyclerView.Adapter<MyChildAdapterCategory.ChildViewHolder>() {



    inner class ChildViewHolder(var vieww: CardView) : RecyclerView.ViewHolder(vieww)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {



        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_activity, parent, false) as CardView
        val vh = ChildViewHolder(view)
        return vh
    }

    override fun getItemCount(): Int {
        return arrayy.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        var view=holder.itemView
        val image=view.findViewById<ImageView>(R.id.image)
        val text=view.findViewById<TextView>(R.id.text)
        Picasso.with(con).load(arrayy[position].url).into(image)
        text.text = arrayy[position].text
    }
}