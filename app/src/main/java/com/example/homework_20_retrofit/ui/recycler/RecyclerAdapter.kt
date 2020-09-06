package com.example.homework_20_retrofit.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_20_retrofit.R
import com.example.homework_20_retrofit.data.model.current.forecast.ForecastItem
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerAdapter : RecyclerView.Adapter<RvHolder>() {

    val list = arrayListOf<ForecastItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout,parent,false)
        return RvHolder(view)
    }
    fun update(list: List<ForecastItem>?) {

        if (list!= null ){
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(list[position])
        }

    }

class RvHolder(v:View) : RecyclerView.ViewHolder(v){
    fun bind(forecastItem: ForecastItem) {
        itemView.tv_recycler.text = forecastItem.main.temp.toString()

    }
}
