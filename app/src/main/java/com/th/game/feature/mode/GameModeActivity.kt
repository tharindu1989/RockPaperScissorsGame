package com.th.game.feature.mode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.th.game.R
import kotlinx.android.synthetic.main.activity_game_mode.*

class GameModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        setListeners()
    }

    private fun setListeners() {

        playerVsComBtn.setOnClickListener {

        }
        comVsComBtn.setOnClickListener {

        }
        exitBtn.setOnClickListener {
            finish()
        }
    }
}
