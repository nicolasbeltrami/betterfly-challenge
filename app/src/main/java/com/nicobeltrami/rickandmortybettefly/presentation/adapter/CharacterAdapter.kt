package com.nicobeltrami.rickandmortybettefly.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nicobeltrami.rickandmortybettefly.databinding.ItemCharacterBinding
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterState

class CharacterAdapter() : ListAdapter<CharacterState, CharacterAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CharacterState>() {
            override fun areItemsTheSame(
                oldItem: CharacterState,
                newItem: CharacterState
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: CharacterState,
                newItem: CharacterState
            ): Boolean =
                oldItem == newItem
        }
    }

    inner class ViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterState) {
            with(binding) {
                tvName.text = item.name
                tvGender.text = item.gender
                ivCharacter.load(item.image)
            }
        }
    }
}
