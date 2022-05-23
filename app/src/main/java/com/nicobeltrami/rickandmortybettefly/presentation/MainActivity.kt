package com.nicobeltrami.rickandmortybettefly.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicobeltrami.rickandmortybettefly.R
import com.nicobeltrami.rickandmortybettefly.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}