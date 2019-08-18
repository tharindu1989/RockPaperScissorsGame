package com.th.game.extention

import android.content.res.Resources

/**
 * Created By Tharindu on 8/18/2019
 *
 */

fun Int.toPixel(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}