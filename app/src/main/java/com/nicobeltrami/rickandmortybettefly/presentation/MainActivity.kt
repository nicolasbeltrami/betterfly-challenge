package com.nicobeltrami.rickandmortybettefly.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicobeltrami.rickandmortybettefly.R
import com.nicobeltrami.rickandmortybettefly.databinding.ActivityMainBinding
import com.nicobeltrami.rickandmortybettefly.presentation.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter(
            onItemClicked = {  }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun setupRecyclerView() {
        with(binding) {
            rvCharacters.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCharacters.adapter = adapter
        }
    }

}