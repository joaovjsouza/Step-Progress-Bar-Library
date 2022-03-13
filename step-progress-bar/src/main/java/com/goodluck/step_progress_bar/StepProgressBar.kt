package com.goodluck.step_progress_bar

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.goodluck.step_progress_bar.databinding.ResStepProgressBarBinding

class StepProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding =
        ResStepProgressBarBinding.inflate(LayoutInflater.from(context), this, true)

    val state = ProgressBarState(
        binding.progressBar,
        tvLabel = binding.tvStepLabel,
        tvIndex = binding.tvStepIndex
    )
    val progressBarMargin = MarginConfigurator(binding.progressBar)
    val tvStepLabelMargin = MarginConfigurator(binding.tvStepLabel)
    val tvStepIndexMargin = MarginConfigurator(binding.tvStepIndex)

    var progressBackground: Int? = null
        set(value) {
            value?.let {
                field = it
                binding.progressBar.progressDrawable = context.getDrawable(it)
            }
        }

    init {
        setLayout(attrs)
    }

    private fun setLayout(attributes: AttributeSet?) {
        attributes?.let {
            val attr = context.obtainStyledAttributes(it, R.styleable.StepProgressBar)

            progressBackground = attr.getResourceId(
                R.styleable.StepProgressBar_progress_background,
                R.drawable.default_bg
            )

            tvStepLabelMargin.horizontal = 30
            tvStepIndexMargin.horizontal = 30
        }
    }
}