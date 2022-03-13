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

//        progressbar.state.steps =
//            mutableListOf("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado")

        val btnNext = binding.btnNextStep
        val btnPrevious = binding.btnPreviousStep

        btnNext.setOnClickListener {
            progressbar.state.increment()
        }

        btnPrevious.setOnClickListener {
            progressbar.state.decrement()
        }
    }
}