package com.example.countriesapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countriesapp.R
import com.example.countriesapp.model.Country
import com.example.countriesapp.util.getProgressDrawable
import com.example.countriesapp.util.loadImage
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(
    var countries: ArrayList<Country>
) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView = view.imageView
        private val countryName: TextView = view.name
        private val countryCapital: TextView = view.capital
        private val progressDrawable = getProgressDrawable(view.context)

        fun bind(country: Country) {
            imageView.loadImage(country.flag, progressDrawable)
            countryName.text = country.countryName
            countryCapital.text = country.capital
        }
    }
}