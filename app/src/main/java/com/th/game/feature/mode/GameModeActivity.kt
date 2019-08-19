package com.th.game.feature.mode

import android.os.Bundle
import com.th.game.R
import com.th.game.core.util.GameType
import com.th.game.feature.base.BaseActivity
import com.th.game.feature.game.GameActivity
import kotlinx.android.synthetic.main.activity_game_mode.*

class GameModeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        setListeners()
    }

    private fun setListeners() {

        playerVsComBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("type", GameType.COMPUTER_PLAYER)
            openNewActivity(
                activity = GameActivity::class.java,
                bundle = bundle
            )
        }
        comVsComBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("type", GameType.COMPUTER)
            openNewActivity(
                activity = GameActivity::class.java,
                bundle = bundle
            )
        }
        exitBtn.setOnClickListener {
            finish()
        }
    }
}
