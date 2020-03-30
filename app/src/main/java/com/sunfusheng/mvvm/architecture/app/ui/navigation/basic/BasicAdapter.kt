package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.sunfusheng.mvvm.architecture.app.R

/**
 * @author sunfusheng
 * @since 2020/3/30
 */
class BasicAdapter(private val dataSource: List<String>?) :
    RecyclerView.Adapter<BasicAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vColor: TextView = itemView.findViewById(R.id.vColor)

        fun bind(colorString: String) {
            vColor.text = colorString
            vColor.setBackgroundColor(Color.parseColor(colorString))
            itemView.setOnClickListener {
                val direction =
                    BasicListFragmentDirections.actionBasicListFragmentToBasicDetailFragment(
                        colorString
                    )
                val extras = FragmentNavigatorExtras(
                    vColor to vColor.context.getString(R.string.transition_name_basic_nav_color)
                )
                itemView.findNavController().navigate(direction, extras)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSource?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSource!![position])
    }
}