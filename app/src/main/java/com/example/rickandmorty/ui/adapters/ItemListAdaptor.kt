package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.FragmentCharacterListBinding
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.databinding.ItemLocationBinding
import com.example.rickandmorty.ui.model.CharacterItem
import com.example.rickandmorty.ui.model.EpisodeItem
import com.example.rickandmorty.ui.model.Item
import com.example.rickandmorty.ui.model.LocationItem
import java.lang.IllegalArgumentException

class ItemListAdaptor() : ListAdapter<Item, ItemListAdaptor.ItemViewHolder> (
    ItemDiffCallback()
){

    companion object{
        private const val CHARACTER = 0
        private const val EPISODE = 1
        private const val LOCATION = 2
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is CharacterItem -> CHARACTER
        is EpisodeItem -> EPISODE
        is LocationItem -> LOCATION
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            CHARACTER -> {
                val binding = ItemCharacterBinding.inflate(inflater, parent, false)
                CharacterItemViewHolder(binding)
            }
            EPISODE -> {
                EpisodeItemViewHolder(ItemEpisodeBinding.inflate(inflater, parent, false))
            }
            LOCATION -> {
                TODO()
            }
            else -> throw IllegalArgumentException("Unexpected item type")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    abstract inner class ItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        abstract fun bind(item : Item)
    }

    private inner class CharacterItemViewHolder(
        private val binding: ItemCharacterBinding
    ) : ItemViewHolder(binding.root){

        override fun bind(item: Item) {
            if (item !is CharacterItem) return

            with(binding){
                tvName.text = item.name
                tvState.text = item.status.name // TODO status namee
                tvSpecies.text = item.spesies
                tvOriginLocation.text = item.origin
                tvLastLocation.text = item.location
                tvEpisodeCount.text = item.episodes.toString()
            }

        }
    }

    private inner class EpisodeItemViewHolder(
        private val binding: ItemEpisodeBinding
    ): ItemViewHolder(binding.root){
        override fun bind(item: Item) {
            if (item !is EpisodeItem) return
            with(binding){
                tvName.text = item.name
            }
        }
    }




    private class ItemDiffCallback : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

}