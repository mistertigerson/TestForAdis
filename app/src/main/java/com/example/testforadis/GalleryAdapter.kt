package com.example.testforadis

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.testforadis.databinding.ListItemBinding

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {


    private var list: ArrayList<Model> = ArrayList()


    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<Model>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var binding: ListItemBinding

        fun onBind(model: Model) {
            binding = ListItemBinding.bind(itemView)
            binding.image.setImageResource(model.image)
        }

    }


}