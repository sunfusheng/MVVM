package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunfusheng.mvvm.architecture.app.R

/**
 * @author sunfusheng
 * @since 2020/3/30
 */
class BasicAdapter(val dataSource: List<BasicItem>?) :
    RecyclerView.Adapter<BasicAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vName: TextView = itemView.findViewById(R.id.name)
        private val vIcon: ImageView = itemView.findViewById(R.id.icon)

        init {
            itemView.setOnClickListener {

            }
        }

        fun bind(item: BasicItem) {
            vName.text = item.title
            vIcon.setImageDrawable(item.drawable)
        }
    }

    override fun getItemCount(): Int {
        return dataSource?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSource!![position])
    }
}

data class BasicItem(val title: String, val drawable: Drawable)