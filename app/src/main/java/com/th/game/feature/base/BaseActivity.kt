package com.th.game.feature.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created By Tharindu on 8/18/2019
 *
 */
open class BaseActivity : AppCompatActivity() {

    fun openNewActivity(
        activity: Class<*>,
        intent: Intent? = null,
        bundle: Bundle? = null
    ) {
        val newIntent = intent ?: Intent(this, activity)
        newIntent.putExtra("bundle", bundle)
        startActivity(newIntent)
    }
}