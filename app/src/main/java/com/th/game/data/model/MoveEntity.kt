package com.th.game.data.model

import com.th.game.core.util.Move

/**
 * Created By Tharindu on 8/18/2019
 *
 */
data class MoveEntity(
    val move: Move,
    var isEnable: Boolean = false,
    var isHide: Boolean = false
)