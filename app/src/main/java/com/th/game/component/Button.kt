package com.th.game.component

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.Button
import com.th.game.R
import com.th.game.extention.toPixel

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class Button @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    companion object {
        const val ACTIVE_BUTTON = "active"
        const val NEGATIVE_BUTTON = "negative"
    }

    init {

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.CustomButton, 0, 0
            )
            val type = typedArray.getString(R.styleable.CustomButton_type)

            when (type) {
                ACTIVE_BUTTON -> {
                    this.setBackgroundResource(R.drawable.active_button)
                }
                NEGATIVE_BUTTON -> {
                    this.setBackgroundResource(R.drawable.negative_button)
                }
            }
        }
        this.setPadding(20.toPixel(), 20.toPixel(), 20.toPixel(), 30.toPixel())
        setTextColor(resources.getColor(R.color.white))
        textSize = 20f
        gravity = Gravity.CENTER
    }
}