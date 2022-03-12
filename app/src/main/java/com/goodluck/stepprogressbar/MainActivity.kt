package com.goodluck.stepprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goodluck.stepprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressbar = binding.stepProgressBar

        progressbar.progressBackground = R.drawable.custom_progress_bg

        progressbar.state.steps = mutableListOf("Começo", "Fim")
        progressbar.state.actualProgress = 1
    }
}