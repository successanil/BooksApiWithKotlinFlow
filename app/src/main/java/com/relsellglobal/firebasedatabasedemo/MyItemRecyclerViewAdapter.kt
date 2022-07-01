/*
 * Copyright (c) 2019. Relsell Global
 */

package com.relsellglobal.firebasedatabasedemo


import com.relsellglobal.firebasedatabasedemo.databinding.FragmentItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.modelslib.CityContent
import com.relsellglobal.modelslib.CityContentNetwork

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val mValues: List<CityContent>,
    private val activity: FragmentActivity?
    ) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding : FragmentItemBinding
    private var VIEW_TYPE_HEADER = 0
    private var VIEW_TYPE_ITEM = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.fragment_item, parent, false)
        if(viewType == VIEW_TYPE_HEADER) {
            // we can have different views here
            return ViewHolder(binding.root)
        } else if(viewType == VIEW_TYPE_ITEM) {
            // we can have different view here
            return ViewHolder(binding.root)
        } else {
            // we can have different view here
            return ViewHolder(binding.root)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item.cityName
        holder.mView.setOnClickListener({
            //lets do some thing
            try {

                val des = if(activity is MainActivityWithNavBar) activity else null
                des?.launchDetailFragment(item)
            } catch (e:Exception) {
                e.printStackTrace()
            }


        })

    }

    override fun getItemViewType(position: Int): Int {
        if(position == 1) return VIEW_TYPE_HEADER else return VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val mContentView: TextView = mView.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
