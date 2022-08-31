package com.example.firect

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CListAdapter(private val getContext:Context,private val customListItem:ArrayList<CList>):
    ArrayAdapter<CList>(getContext,0,customListItem)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listLayout=convertView
        val holder: ViewHolder
        if(listLayout==null)
        {
            val inflateList=(getContext as Activity).layoutInflater
            listLayout=inflateList!!.inflate(R.layout.custom_list,parent,false)
            holder=ViewHolder()
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv1)
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv2)
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv3)
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv4)
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv5)
            holder.mTextViewOne=listLayout!!.findViewById<TextView>(R.id.tv6)
            holder.mImageListView=listLayout!!.findViewById<ImageView>(R.id.image)
            listLayout.setTag(holder)

        }
        else
        {
            holder=listLayout.getTag()as ViewHolder
        }

        val listItem=customListItem[position]
        holder.mTextViewOne!!.setText(listItem.mCListTextOne)
        holder.mTextViewTwo!!.setText(listItem.mCListTextOne)
        holder.mTextViewThree!!.setText(listItem.mCListTextOne)
        holder.mTextViewFour!!.setText(listItem.mCListTextOne)
        holder.mTextViewFive!!.setText(listItem.mCListTextOne)
        holder.mTextViewSix!!.setText(listItem.mCListTextOne)
        holder.mImageListView!!.setImageResource(listItem.mCListImage)

        return listLayout
    }
    class ViewHolder
    {
        internal var mTextViewOne:TextView?=null
        internal var mTextViewTwo:TextView?=null
        internal var mTextViewThree:TextView?=null
        internal var mTextViewFour:TextView?=null
        internal var mTextViewFive:TextView?=null
        internal var mTextViewSix:TextView?=null
        internal var mImageListView: ImageView?=null


    }

}