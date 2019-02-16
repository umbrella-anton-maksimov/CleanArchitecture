package com.course.clean.view.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.*
import com.course.clean.R
import com.course.clean.entity.Movie
import com.course.clean.view.adapter.MoviesAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by antonmaksimov on 1/31/19.
 * anton.maksimov@umbrella-web.com
 */

class MoviesAdapter : RecyclerView.Adapter<ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            itemView.textName.text = movie.name
            itemView.textYear.text = movie.year
            itemView.setOnClickListener {
                onClickListener?.invoke(movie)
            }
        }
    }

    private var data: List<Movie> = emptyList()

    var onClickListener: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun getItemId(position: Int) = data[position].id

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = data[position]
        viewHolder.bind(movie)
    }

    fun updateContent(data: List<Movie>) {
        val callback = Callback(this.data, data)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
        this.data = data
    }

    private class Callback(val oldList: List<Movie>,
                           val newList: List<Movie>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.id == newItem.id
        }

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.name == newItem.name &&
                    oldItem.year == newItem.year

        }
    }
}