package com.example.firect_direct_from_farm.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.media.Image
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.firect_direct_from_farm.*
import com.example.firect_direct_from_farm.MyAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.collection.LLRBNode
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class homeFragment : Fragment(), Runnable {

    lateinit var con:Context
    var array= mutableListOf<Category>()
   lateinit var recyclerView:RecyclerView
   var array_banner= mutableListOf<Banner>()
   lateinit var  page_refresh:SwipeRefreshLayout
   var array_deals= mutableListOf<Deals>()
    var array_seasonal= mutableListOf<Seasonal>()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity)
        {
            con=context
        }
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {




        val view=inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView=view.findViewById<RecyclerView>(R.id.my_main_rv)
        recyclerView.isNestedScrollingEnabled=true
        recyclerView.layoutManager=LinearLayoutManager(con)
        page_refresh=view.findViewById<SwipeRefreshLayout>(R.id.page_refresh)
        page_refresh.isRefreshing=true
        page_refresh.setColorSchemeColors(Color.BLUE)
        page_refresh.setProgressBackgroundColorSchemeColor(Color.WHITE)











    Firebase.database.reference.child("categories").addListenerForSingleValueEvent(
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val readItem = snapshot.value as Map<String, Map<String, String>>

                array.clear()

                for (i in readItem.values) {
                    val url = i["image"].toString()
                    val text = i["text"].toString()
                    val item = Category(url, text)
                    array.add(item)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
            }


        }
    )
    Firebase.database.reference.child("banner").addListenerForSingleValueEvent(

        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val readitem = snapshot.value as Map<String, Map<String, String>>
                array_banner.clear()
                for (i in readitem.values) {
                    val url = i["url"].toString()
                    val banner = Banner(url)
                    array_banner.add(banner)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
            }

        }
    )

    Firebase.database.reference.child("deals").addListenerForSingleValueEvent(
        object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val readitem = snapshot.value as Map<String, Map<String, String>>
                array_deals.clear()

                for (i in readitem.values) {
                    val url = i["image"].toString()
                    val name = i["name"].toString()
                    val price = i["price"].toString()
                    val deal = Deals(url, name, price)
                    array_deals.add(deal)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
            }

        }
    )

        Firebase.database.reference.child("seasonal").addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val readitem = snapshot.value as Map<String, Map<String, String>>
                     array_seasonal.clear()

                    for (i in readitem.values) {
                        val url = i["url"].toString()
                        val name = i["name"].toString()
                        val seasonal = Seasonal(url, name)
                        array_seasonal.add(seasonal)
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
                }

            }
        )


        val handler = Handler()
    val delay: Long = 1000



    handler.postDelayed(
        Runnable {


//                if(array.isNotEmpty() && array_banner.isNotEmpty())
//                {
//                    recyclerView.adapter= MyAdapter(con,array,array_banner)
//                    page_refresh.isRefreshing=false
//
//                }

            handler.postDelayed(this, delay)


        }, delay)



        page_refresh.setOnRefreshListener {

            Firebase.database.reference.child("categories").addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val readItem = snapshot.value as Map<String, Map<String, String>>


                        array.clear()
                        for (i in readItem.values) {
                            val url = i["image"].toString()
                            val text = i["text"].toString()
                            val item = Category(url, text)
                            array.add(item)

                        }


                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
                    }


                }
            )

            Firebase.database.reference.child("banner").addListenerForSingleValueEvent(

                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val readitem = snapshot.value as Map<String, Map<String, String>>
                        array_banner.clear()
                        for (i in readitem.values) {
                            val url = i["url"].toString()
                            val banner = Banner(url)
                            array_banner.add(banner)


                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
                    }

                }
            )


            Firebase.database.reference.child("deals").addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        val readitem = snapshot.value as Map<String, Map<String, String>>
                        array_deals.clear()

                        for (i in readitem.values) {
                            val url = i["image"].toString()
                            val name = i["name"].toString()
                            val price = i["price"].toString()
                            val deal = Deals(url, name, price)
                            array_deals.add(deal)
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
                    }

                }
            )

            Firebase.database.reference.child("seasonal").addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        val readitem = snapshot.value as Map<String, Map<String, String>>
                        array_seasonal.clear()

                        for (i in readitem.values) {
                            val url = i["url"].toString()
                            val name = i["name"].toString()
                            val seasonal = Seasonal(url, name)
                            array_seasonal.add(seasonal)
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(con, error.toString(), Toast.LENGTH_LONG).show()
                    }

                }
            )



            val handler=Handler()
            val delay:Long=1000



            handler.postDelayed(
                Runnable {


                    if(array.isNotEmpty() && array_banner.isNotEmpty() && array_deals.isNotEmpty() && array_seasonal.isNotEmpty())
                    {
                        recyclerView.adapter= MyAdapter(con,array,array_banner,array_deals,array_seasonal)
                    }
                    else
                    {
                        handler.postDelayed(this,delay)
                    }

                }




                , delay)


            page_refresh.isRefreshing=false
        }




        return view

    }


    companion object {

        fun newInstance():homeFragment
        {
            return homeFragment()
        }

    }


    override fun run() {

        if(array.isNotEmpty() && array_banner.isNotEmpty() && array_deals.isNotEmpty()&& array_seasonal.isNotEmpty())
        {
            recyclerView.adapter= MyAdapter(con,array,array_banner,array_deals,array_seasonal)
            page_refresh.isRefreshing=false


        }


    }


}
