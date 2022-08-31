package com.example.firect_direct_from_farm

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyChildViewHolderDeals(var view:LinearLayout):RecyclerView.ViewHolder(view)
class MyChildAdapterDeals(var con:Context,var array_deals:MutableList<Deals>):
    RecyclerView.Adapter<MyChildViewHolderDeals>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChildViewHolderDeals {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.deal_activity,parent,false) as LinearLayout
        val vh=MyChildViewHolderDeals(view)
        return vh
    }

    override fun onBindViewHolder(holder: MyChildViewHolderDeals, position: Int) {
        val view=holder.itemView
        val image_deal=view.findViewById<ImageView>(R.id.deal_image)
        val name_text=view.findViewById<TextView>(R.id.name_text)
        val discount_text=view.findViewById<TextView>(R.id.discount_text)
        val show_more=view.findViewById<Button>(R.id.show_more)
        Picasso.with(con).load(array_deals[position].url).into(image_deal)
        name_text.text=array_deals[position].name
        discount_text.text=array_deals[position].price



    }

    override fun getItemCount(): Int {
        return array_deals.size

    }

}