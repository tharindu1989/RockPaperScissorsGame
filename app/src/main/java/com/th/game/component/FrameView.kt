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

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class FrameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var icon: Int? = null
        set(value) {
            proImg.setImageResource(value ?: R.drawable.ic_person_black_24dp)
        }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.frame_layout, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.UserFrame, 0, 0
            )
            val img = typedArray.getResourceId(R.styleable.UserFrame_user, R.drawable.ic_person_black_24dp)
            val title = typedArray.getString(R.styleable.UserFrame_title)

            proImg.setImageResource(img)
            titleTxt.text = title

        }
    }
}