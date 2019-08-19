package com.th.game.feature.game.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.th.game.R
import com.th.game.core.util.Move
import com.th.game.data.model.MoveEntity

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class MoveAdapter : RecyclerView.Adapter<MoveViewHolder>() {

    private var items: ArrayList<MoveEntity> = arrayListOf()
    var clickListener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MoveViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item, position)
        holder.setOnClickListener(clickListener)
    }

    fun refreshItems(items: ArrayList<MoveEntity>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClick(move: Move, index: Int)
    }

}

class MoveViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.move_item, parent, false)) {

    private val iconImage = itemView.findViewById<ImageView>(R.id.iconImg)
    private val background = itemView.findViewById<LinearLayout>(R.id.background)
    var clickListener: MoveAdapter.ClickListener? = null
    fun bindData(move: MoveEntity, index: Int) {
        iconImage.setImageResource(move.move.getIcon())

        if (move.isEnable) {
            background.setBackgroundResource(R.drawable.background_move)
        } else {
            background.setBackgroundResource(R.drawable.background_move_disable)
        }

        if (move.isHide) {
            background.visibility = View.INVISIBLE
        } else {
            background.visibility = View.VISIBLE
        }

        background.setOnClickListener {
            if (move.isEnable)
                clickListener?.onClick(move.move, index)
        }
    }

    fun setOnClickListener(listener: MoveAdapter.ClickListener?) {
        this.clickListener = listener
    }
}