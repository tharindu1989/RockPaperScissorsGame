package com.th.game.core.util

import com.th.game.R

/**
 * Created By Tharindu on 8/17/2019
 *
 */
enum class Move {
    ROCK {
        override fun getWeight(): Int = 1
        override fun getIcon(): Int = R.drawable.rock
    },
    PAPER {
        override fun getWeight(): Int = 2
        override fun getIcon(): Int = R.drawable.paper
    },
    SCISSOR {
        override fun getWeight(): Int = 3
        override fun getIcon(): Int = R.drawable.scissors
    };

    abstract fun getWeight(): Int
    abstract fun getIcon(): Int
}
