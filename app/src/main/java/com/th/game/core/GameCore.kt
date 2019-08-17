package com.th.game.core

import com.th.game.core.util.Move
import com.th.game.core.util.ResultMode
import java.util.concurrent.ThreadLocalRandom

/**
 * Created By Tharindu on 8/17/2019
 *
 */
class GameCore {

    val moveList = enumValues<Move>()

    /**
     * get random Move
     */
    fun generateAutoMove(): Move {

        val randomIndex: Int = ThreadLocalRandom.current().nextInt(0, moveList.lastIndex)

        return moveList[randomIndex]
    }

    /**
     * get Result for [moveTwo]
     */
    fun getGameResult(moveOne: Move, moveTwo: Move): ResultMode {

        if (moveOne == moveTwo)
            return ResultMode.DRAW

        val highestValue = getHighest(moveOne, moveTwo)
        if (highestValue == moveTwo)
            return ResultMode.WIN
        else
            return ResultMode.LOST
    }

    /**
     * get Highest Move from [moveOne] and [moveTwo]
     */
    fun getHighest(moveOne: Move, moveTwo: Move): Move {

        return if (isLastAndFirstMoves(moveOne, moveTwo)) {
            moveList.first()
        } else {
            when {
                moveOne.getWeight() > moveTwo.getWeight() -> {
                    moveOne
                }
                else -> {
                    moveTwo
                }
            }
        }
    }

    /**
     * check [moveOne] and [moveTwo] are
     * first and last item of move list
     */
    fun isLastAndFirstMoves(moveOne: Move, moveTwo: Move): Boolean {

        val firstAndLastItem = arrayListOf(moveList.first(), moveList.last())

        return firstAndLastItem.containsAll(arrayListOf(moveOne, moveTwo))
    }
}