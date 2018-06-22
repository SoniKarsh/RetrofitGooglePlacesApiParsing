package com.example.karshsoni.retrofitdemogoogleplaces

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DataAdapter(var items: ModelClass, var context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uLat.text = items.candidates!![holder.adapterPosition].geometry.location.lat.toString()
        holder.uLng.text = items.candidates!![holder.adapterPosition].geometry.location.lng.toString()
        holder.uState.text = items.candidates!![holder.adapterPosition].formattedAddress
        holder.uName.text = items.candidates!![holder.adapterPosition].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_list_view, parent, false))
    }

    override fun getItemCount(): Int {
        return items.candidates!!.size
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    var uLat = view.findViewById<TextView>(R.id.textView)
    var uLng = view.findViewById<TextView>(R.id.textView2)
    var uState = view.findViewById<TextView>(R.id.textView3)
    var uName = view.findViewById<TextView>(R.id.textView4)
}