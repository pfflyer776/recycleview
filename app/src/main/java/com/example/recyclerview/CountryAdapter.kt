package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countryList : ArrayList<CountryModel>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val countryName = itemView.findViewById<TextView>(R.id.country_name)
        val countryRegion = itemView.findViewById<TextView>(R.id.country_region)
        val countryCode = itemView.findViewById<TextView>(R.id.country_code)
        val countryCapital = itemView.findViewById<TextView>(R.id.country_capital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false))
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        val country = countryList[position]

        holder.countryName.text = country.name
        holder.countryRegion.text = country.region
        holder.countryCode.text = country.code
        holder.countryCapital.text = country.capital
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}