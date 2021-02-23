package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sunfusheng.mvvm.app.R

/**
 * @author sunfusheng
 * @since 2020/3/30
 */
class BasicAdapter(val dataSource: List<String>) :
    RecyclerView.Adapter<BasicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_color, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val vColor: TextView = itemView.findViewById(R.id.vColor)

        fun bind(colorString: String) {
            vColor.text = colorString
            vColor.setBackgroundColor(Color.parseColor(colorString))
            itemView.setOnClickListener {
                val direction =
                    BasicListFragmentDirections.actionBasicListFragmentToBasicDetailFragment(
                        colorString
                    )
                itemView.findNavController().navigate(direction)
            }
        }
    }
}