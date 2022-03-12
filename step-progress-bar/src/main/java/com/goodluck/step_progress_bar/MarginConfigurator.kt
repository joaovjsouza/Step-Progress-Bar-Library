package com.goodluck.step_progress_bar

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup

class MarginConfigurator(private val view: View) {
    private val marginLayout = view.layoutParams as ViewGroup.MarginLayoutParams

    private fun Int.toDp(): Int =
        (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    var right: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.rightMargin = it.toDp()
            }
        }

    var left: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.leftMargin = it.toDp()
            }
        }

    var horizontal: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.rightMargin = it.toDp()
                marginLayout.leftMargin = it.toDp()
            }
        }

    var vertical: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.bottomMargin = it.toDp()
                marginLayout.topMargin = it.toDp()
            }
        }

    var top: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.topMargin = it.toDp()
            }
        }

    var bottom: Int? = null
        set(value) {
            value?.let {
                field = it
                marginLayout.bottomMargin = it.toDp()
            }
        }
}