package com.example.githubstars.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubstars.data.model.Item
import com.example.githubstars.databinding.ResultListItemBinding

class ResultAdapter : PagingDataAdapter<Item, ResultAdapter.ResultViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding =
            ResultListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding)
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.id == newItem.id
        }
    }

    inner class ResultViewHolder(
        val binding: ResultListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.authorNameRepository.text = item.owner.login
            binding.nameRepository.text = item.name
            binding.forksRepository.text = "Quantidade de Forks: " + item.forks.toString()
            binding.starsRepository.text =
                "Quantidade de estrelas: " + item.stargazersCount.toString()
            Glide
                .with(binding.authorImageRepository.context)
                .load(item.owner.avatarUrl)
                .into(binding.authorImageRepository)

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(item)
                }
            }
        }
    }


    private var onItemClickListener: ((Item) -> Unit)? = null

    fun setOnItemClickListener(listener: (Item) -> Unit) {
        onItemClickListener = listener
    }
}