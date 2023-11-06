package ru.perelyginva.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.perelyginva.test.R
import ru.perelyginva.test.databinding.TvShowItemLayoutBinding
import ru.perelyginva.test.models.TvShowItem

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val diffCallback = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            tvTitle.text = currentTvShow.name
            imTV.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_startFragment_to_tvAboutFragment)

        }
    }

    override fun getItemCount() = tvShows.size

}