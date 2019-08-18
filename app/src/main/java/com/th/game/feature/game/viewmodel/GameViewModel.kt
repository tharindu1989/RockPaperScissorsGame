package com.th.game.feature.game.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.th.game.core.util.ResultMode

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class GameViewModel : ViewModel() {

    val oneSecond: Long = 1000
    val totalTimeToExpire = oneSecond * 5

    private val countDown: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also {
            startCounter()
        }
    }

    private val result: MutableLiveData<ResultMode> by lazy {
        MutableLiveData<ResultMode>()
    }

    private fun startCounter() {
        val timer = object : CountDownTimer(totalTimeToExpire, oneSecond) {
            override fun onFinish() {
                checkResult()
            }

            override fun onTick(p0: Long) {
                countDown.value = (p0 / oneSecond).toInt()
            }
        }
        timer.start()
    }

    private fun checkResult() {

    }


    fun getCount(): MutableLiveData<Int> = countDown
}