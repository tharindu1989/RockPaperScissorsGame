package com.th.game.feature.game.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.th.game.core.GameCore
import com.th.game.core.util.GameType
import com.th.game.core.util.Move
import com.th.game.core.util.ResultMode
import com.th.game.data.model.MoveEntity

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class GameViewModel : ViewModel() {

    val oneSecond: Long = 1000
    val totalTimeToExpire = oneSecond * 5

    var selectedOne: Move? = null
    var selectedTwo: Move? = null

    val gameMode: MutableLiveData<GameType> by lazy {
        MutableLiveData<GameType>()
    }

    val itemsForPlayerOne: MutableLiveData<ArrayList<MoveEntity>> by lazy {
        MutableLiveData<ArrayList<MoveEntity>>().also {
            it.value = getMoveEntityList()
        }
    }

    val itemsForPlayerTwo: MutableLiveData<ArrayList<MoveEntity>> by lazy {
        MutableLiveData<ArrayList<MoveEntity>>().also {
            it.value = getMoveEntityList()
        }
    }

    private val countDown: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private val result: MutableLiveData<ResultMode> by lazy {
        MutableLiveData<ResultMode>()
    }

    fun startCounter() {
        val timer = object : CountDownTimer(totalTimeToExpire, oneSecond) {
            override fun onFinish() {
                checkResult()
            }

            override fun onTick(p0: Long) {
                countDown.value = (p0 / oneSecond).toInt()
            }
        }
        timer.start()
        when (gameMode.value) {
            GameType.COMPUTER -> {
                changeStatusOnListOne(false)
                changeStatusOnListTwo(false)
            }
            GameType.COMPUTER_PLAYER -> {
                changeStatusOnListOne(true)
                changeStatusOnListTwo(false)
            }
        }
    }

    private fun checkResult() {

        when (gameMode.value) {
            GameType.COMPUTER -> {
                val selectedValueOne = GameCore().generateAutoMove()
                val selectedValueTwo = GameCore().generateAutoMove()

                setSelectedItemForListOne(selectedValueOne)
                setSelectedItemForListTwo(selectedValueTwo)
            }
            GameType.COMPUTER_PLAYER -> {
                val selected = GameCore().generateAutoMove()
                setSelectedItemForListTwo(selected)
            }
        }
        selectedOne?.let {
            result.value = GameCore().getGameResult(selectedOne ?: Move.PAPER, selectedTwo ?: Move.PAPER)
        } ?: run {
            result.value = ResultMode.WIN
        }
    }

    private fun getMoveEntityList(): ArrayList<MoveEntity> {
        val items = arrayListOf<MoveEntity>()
        enumValues<Move>().map {
            items.add(MoveEntity(it, false))
        }
        return items
    }

    private fun changeStatusOnListOne(enable: Boolean) {
        val items = arrayListOf<MoveEntity>()
        enumValues<Move>().map {
            items.add(MoveEntity(it, enable))
        }
        itemsForPlayerOne.value = items
    }

    private fun changeStatusOnListTwo(enable: Boolean) {
        val items = arrayListOf<MoveEntity>()
        enumValues<Move>().map {
            items.add(MoveEntity(it, enable))
        }
        itemsForPlayerTwo.value = items
    }

    fun setSelectedItemForListOne(item: Move) {
        selectedOne = item
        val items = arrayListOf<MoveEntity>()
        enumValues<Move>().map {
            if (item == it)
                items.add(MoveEntity(it, true, false))
            else
                items.add(MoveEntity(it, true, true))
        }
        itemsForPlayerOne.value = items
    }

    fun setSelectedItemForListTwo(item: Move) {
        selectedTwo = item
        val items = arrayListOf<MoveEntity>()
        enumValues<Move>().map {
            if (item == it)
                items.add(MoveEntity(it, true, false))
            else
                items.add(MoveEntity(it, true, true))
        }
        itemsForPlayerTwo.value = items
    }

    fun getCount(): MutableLiveData<Int> = countDown
    fun getResultMode(): MutableLiveData<ResultMode> = result
}