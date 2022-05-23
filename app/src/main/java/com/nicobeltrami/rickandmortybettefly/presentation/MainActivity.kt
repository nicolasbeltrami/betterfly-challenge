package com.nicobeltrami.rickandmortybettefly.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicobeltrami.rickandmortybettefly.databinding.ActivityMainBinding
import com.nicobeltrami.rickandmortybettefly.presentation.adapter.CharacterAdapter
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterState
import com.nicobeltrami.rickandmortybettefly.presentation.model.ScreenEvent
import com.nicobeltrami.rickandmortybettefly.presentation.model.ScreenState
import com.nicobeltrami.rickandmortybettefly.presentation.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<CharacterListViewModel>()
    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter(
            onItemClicked = { id -> navigateToDetails(id) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModelChanges()
        viewModel.postEvent(ScreenEvent.OnInitEvent)

    }

    private fun setupRecyclerView() {
        with(binding) {
            rvCharacters.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCharacters.adapter = adapter
        }
    }

    private fun observeViewModelChanges() {
        viewModel.screenState.observe(this) { state ->
            when (state) {
                is ScreenState.OnLoadingState -> {
                    hideUi()
                }

                is ScreenState.OnLoadedState -> {
                    showUi()
                    loadCharacters(state.charactersList)
                }
            }
        }
    }

    private fun loadCharacters(characters: List<CharacterState>) {
        adapter.submitList(characters)
    }

    private fun showUi() {
        binding.rvCharacters.isVisible = true
        binding.pbCharacters.isVisible = false
    }

    private fun hideUi() {
        binding.rvCharacters.isVisible = false
        binding.pbCharacters.isVisible = true
    }

    private fun navigateToDetails(id: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }
}
