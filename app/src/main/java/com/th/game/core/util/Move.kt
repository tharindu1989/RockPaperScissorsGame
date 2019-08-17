package com.th.game.core.util

/**
 * Created By Tharindu on 8/17/2019
 *
 */
enum class Move {
    ROCK {
        override fun getWeight(): Int = 1
    },
    PAPER {
        override fun getWeight(): Int = 2
    },
    SCISSOR {
        override fun getWeight(): Int = 3
    };

    abstract fun getWeight(): Int
}
