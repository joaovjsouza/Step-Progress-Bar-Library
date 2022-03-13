package com.goodluck.step_progress_bar

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.math.max

class ProgressBarState(
    private val progressBar: ProgressBar,
    private val tvLabel: TextView,
    private val tvIndex: TextView
) {

    var steps: MutableList<String>? = null
        set(value) {
            value?.let {
                field = it
                commit()
            }
        }

    var actualProgress: Int = 0
        set(value) {
            field = value
            commit()
        }

    private fun commit() {
        steps?.let {
            progressBar.max = it.size

            if (actualProgress <= 0) {
                actualProgress = 1
            }

            if (actualProgress > it.size) {
                actualProgress = it.size
            }

            if (actualProgress > 0 && actualProgress <= it.size) {
                progressBar.progress = actualProgress
                tvIndex.text = "${actualProgress}/${it.size}"
                tvLabel.text = it[actualProgress.minus(1)]
            }
        }
    }

    fun increment() {
        actualProgress = actualProgress.plus(1)
    }

    fun decrement() {
        actualProgress = actualProgress.minus(1)
    }
}