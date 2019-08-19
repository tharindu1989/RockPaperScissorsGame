package com.th.game.feature.game.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.th.game.R
import com.th.game.core.util.GameType
import com.th.game.core.util.ResultMode
import com.th.game.feature.base.BaseFragment
import com.th.game.feature.game.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class ResultFragment : BaseFragment() {

    companion object {
        const val TAG = "ResultFragment"
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retryBtn?.setOnClickListener {
            mActivity?.retry()
        }
        exitBtn?.setOnClickListener {
            mActivity?.exitApp()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.let {
            ViewModelProviders.of(it).get(GameViewModel::class.java)
        } ?: throw Exception("In valid Activity")

        setObservers()

        getData()
    }

    private fun setObservers() {

    }

    private fun getData() {
        showResult()
    }

    private fun showResult() {
        when (viewModel.getResultMode().value) {
            ResultMode.WIN -> {
                when (viewModel.gameMode.value) {
                    GameType.COMPUTER_PLAYER -> {
                        onPlayerLostOrWin(false)
                    }
                    GameType.COMPUTER -> {
                        onComputerWin(false)
                    }
                }
            }
            ResultMode.LOST -> {
                when (viewModel.gameMode.value) {
                    GameType.COMPUTER_PLAYER -> {
                        onPlayerLostOrWin(true)
                    }
                    GameType.COMPUTER -> {
                        onComputerWin(true)
                    }
                }
            }
            ResultMode.DRAW -> {
                onDraw()
            }
        }
    }

    private fun onDraw() {
        resultImage.setImageResource(R.drawable.draw)
    }

    private fun onPlayerLostOrWin(isWin: Boolean) {
        if (isWin) {
            resultImage.setImageResource(R.drawable.won)
        } else {
            resultImage.setImageResource(R.drawable.lost)
        }
    }

    private fun onComputerWin(firstComWin: Boolean) {
        if (firstComWin) {
            resultImage.setImageResource(R.drawable.won_computer_one)
        } else {
            resultImage.setImageResource(R.drawable.won_computer_two)
        }
    }
}