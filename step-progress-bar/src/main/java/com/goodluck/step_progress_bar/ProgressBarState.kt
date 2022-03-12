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
}