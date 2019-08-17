package com.th.game

import com.th.game.core.GameCore
import com.th.game.core.util.Move
import com.th.game.core.util.ResultMode
import org.junit.Assert
import org.junit.Test

/**
 * Created By Tharindu on 8/17/2019
 *
 */

class GameCoreTest {

    @Test
    fun `check moves are first and last items of list`() {

        val firstMove = Move.ROCK
        val lastMove = Move.SCISSOR

        val res = GameCore().isLastAndFirstMoves(firstMove, lastMove)

        Assert.assertEquals(true, res)
    }

    @Test
    fun `check Highest move`() {

        val firstMove = Move.ROCK
        val lastMove = Move.SCISSOR

        val res = GameCore().getHighest(firstMove, lastMove)

        Assert.assertEquals(Move.ROCK, res)
    }

    @Test
    fun `check Game Result`() {

        val rockMove = Move.ROCK
        val scissorMove = Move.SCISSOR

        val paperMove = Move.PAPER

        val res = GameCore().getGameResult(rockMove, scissorMove)
        val res2 = GameCore().getGameResult(rockMove, paperMove)
        val res3 = GameCore().getGameResult(paperMove, paperMove)

        Assert.assertEquals(ResultMode.LOST, res)
        Assert.assertEquals(ResultMode.WIN, res2)
        Assert.assertEquals(ResultMode.DRAW, res3)
    }

    @Test
    fun `get random Move check`() {

        val res = GameCore().generateAutoMove()

        Assert.assertTrue(GameCore().moveList.contains(res))
    }
}