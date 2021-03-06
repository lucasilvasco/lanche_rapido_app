package com.anhanguera.foodshopping.utils

import android.app.Activity
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.anhanguera.foodshopping.R
import com.anhanguera.foodshopping.model.Restaurante
import java.util.*

class RestauranteAdapter(private var activity: Activity, private var items: ArrayList<Restaurante>) : BaseAdapter() {
    private class ViewHolder(row: View?) {

        var restaurante: ImageView? = null

        init {
            this.restaurante = row?.findViewById(R.id.logo_restaurante)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_list_restaurante, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var restauranteDto = items[position]
        viewHolder.restaurante?.setImageResource(restauranteDto.backgroundImage)

        return view as View
    }

    override fun getItem(i: Int): Any {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}