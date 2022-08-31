package com.example.firect_direct_from_farm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyChildAdapterBanner(val array_banner:MutableList<Banner>,val con:Context):RecyclerView.Adapter<MyChildAdapterBanner.MyChildViewHolderBanner>() {
    class MyChildViewHolderBanner(val view:ImageView):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChildViewHolderBanner {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.banner_activity,parent,false) as ImageView
        val vh=MyChildViewHolderBanner(view)
        return vh
    }

    override fun onBindViewHolder(holder: MyChildViewHolderBanner, position: Int) {
        val view=holder.itemView
        val banner=view.findViewById<ImageView>(R.id.banner)
        Picasso.with(con).load(array_banner[position].url).into(banner)
    }

    override fun getItemCount(): Int {
        return array_banner.size
    }

}