package com.example.firect_direct_from_farm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firect_direct_from_farm.fragments.homeFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


internal class MyAdapter(var con: Context,var array:MutableList<Category>,var array_banner:MutableList<Banner>,var array_deals:MutableList<Deals>,var array_seasonal:MutableList<Seasonal>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    inner class ViewHolder(val view: LinearLayout) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val vieww = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_main_rv, parent, false) as LinearLayout
        val vh = ViewHolder(vieww)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val view = holder.itemView
        val recyclerViewCategory=view.findViewById<RecyclerView>(R.id.myrv)
        val recyclerViewBanner=view.findViewById<RecyclerView>(R.id.my_rv_banner)
        val layout=view.findViewById<LinearLayout>(R.id.DealLayout)
        val recyclerViewDeals=layout.findViewById<RecyclerView>(R.id.my_rv_deal)
        val layouts=view.findViewById<LinearLayout>(R.id.SeasonalLayout)
        val recyclerViewSeasonals=layouts.findViewById<RecyclerView>(R.id.my_rv_seasonal)
        recyclerViewCategory.layoutManager= LinearLayoutManager(con,RecyclerView.HORIZONTAL,false)
        recyclerViewCategory.adapter= MyChildAdapterCategory(array, con)
        recyclerViewBanner.layoutManager=LinearLayoutManager(con,RecyclerView.HORIZONTAL,false)
        recyclerViewBanner.adapter=MyChildAdapterBanner(array_banner,con)
        recyclerViewDeals.layoutManager=GridLayoutManager(con,2)
        recyclerViewDeals.adapter=MyChildAdapterDeals(con,array_deals)
        recyclerViewSeasonals.layoutManager=GridLayoutManager(con,2)
        recyclerViewSeasonals.adapter=MyChildAdapterSeasonal(con,array_seasonal)

    }

    override fun getItemCount(): Int {
        return 1
    }
}


