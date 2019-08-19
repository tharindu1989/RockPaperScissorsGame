package com.th.game.component

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import com.th.game.R
import com.th.game.extention.toPixel
import kotlinx.android.synthetic.main.frame_layout.view.*
import kotlinx.android.synthetic.main.timer_layout.view.*

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class TimerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var count: Int = 0
        set(value) {
            setCountDown(value)
        }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.timer_layout, this, true)
    }

    private fun setCountDown(value: Int) {

        val resource = when (value) {
            1 -> {
                R.drawable.one
            }
            2 -> {
                R.drawable.two
            }
            3 -> {
                R.drawable.three
            }
            4 -> {
                R.drawable.four
            }
            5 -> {
                R.drawable.five
            }
            else -> {
                R.drawable.vs
            }
        }
        countImage.setImageResource(resource)
        countImage.visibility = View.VISIBLE
    }


    fun setImageRes(resource: Int) {
        countImage.setImageResource(resource)
        countImage.visibility = View.VISIBLE
    }
}