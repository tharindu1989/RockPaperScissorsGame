package com.th.game.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.th.game.R
import com.th.game.feature.base.BaseActivity
import com.th.game.feature.mode.GameModeActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            openNewActivity(GameModeActivity::class.java)
            finish()
        }, 2000)
    }
}
