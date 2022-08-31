package com.example.firect_direct_from_farm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyChildViewHolderSeasonal(var view: LinearLayout): RecyclerView.ViewHolder(view)
class MyChildAdapterSeasonal(var con: Context, var array_seasonals:MutableList<Seasonal>):
    RecyclerView.Adapter<MyChildViewHolderDeals>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChildViewHolderDeals {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.seasonal_activity,parent,false) as LinearLayout
        val vh=MyChildViewHolderDeals(view)
        return vh
    }

    override fun onBindViewHolder(holder: MyChildViewHolderDeals, position: Int) {
        val view=holder.itemView
        val image_seasonal=view.findViewById<ImageView>(R.id.seasonal_image)
        val name_text=view.findViewById<TextView>(R.id.s_name_text)
        Picasso.with(con).load(array_seasonals[position].url).into(image_seasonal)
        name_text.text=array_seasonals[position].name




    }

    override fun getItemCount(): Int {
        return array_seasonals.size

    }

}