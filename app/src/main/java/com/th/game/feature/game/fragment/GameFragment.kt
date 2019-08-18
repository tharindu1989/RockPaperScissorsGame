package com.th.game.feature.game.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.th.game.R
import com.th.game.core.util.GameType
import com.th.game.core.util.Move
import com.th.game.feature.base.BaseFragment
import com.th.game.feature.game.adapter.MoveAdapter
import com.th.game.feature.game.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class GameFragment : BaseFragment() {

    companion object {
        const val TAG = "GameFragment"
    }

    private lateinit var viewModel: GameViewModel
    private var playerOneAdapter = MoveAdapter()
    private var playerTwoAdapter = MoveAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.let {
            ViewModelProviders.of(it).get(GameViewModel::class.java)
        } ?: throw Exception("In valid Activity")

        setObservers()

        getData()
    }

    private fun initLayout() {

        playerOneAdapter.clickListener = object : MoveAdapter.ClickListener {
            override fun onClick(move: Move, index: Int) {
                viewModel.setSelectedItemForListOne(move)
            }
        }

        playerTwoAdapter.clickListener = object : MoveAdapter.ClickListener {
            override fun onClick(move: Move, index: Int) {
                viewModel.setSelectedItemForListTwo(move)
            }
        }

        playerOneRv.apply {
            adapter = playerOneAdapter
            layoutManager = LinearLayoutManager(context)
        }
        playerTwoRv.apply {
            adapter = playerTwoAdapter
            layoutManager = LinearLayoutManager(context)
        }

        startImg.setOnClickListener {
            startImg.visibility = View.GONE
            viewModel.startCounter()
        }
    }

    private fun setObservers() {

        viewModel.getCount().observe(this, Observer {
            timerView.count = it
        })

        viewModel.itemsForPlayerOne.observe(this, Observer {
            playerOneAdapter.refreshItems(it)
        })
        viewModel.itemsForPlayerTwo.observe(this, Observer {
            playerTwoAdapter.refreshItems(it)
        })
        viewModel.getResultMode().observe(this, Observer {
            timerView.setImageRes(R.drawable.vs)
            Handler().postDelayed({
                mActivity?.addFragment(ResultFragment(), ResultFragment.TAG)
            }, 1000)
        })

        viewModel.gameMode.observe(this, Observer {
            when (it) {
                GameType.COMPUTER_PLAYER -> {
                    playerOne.icon = R.drawable.ic_person_black_24dp
                    playerTwo.icon = R.drawable.ic_personal_video_black_24dp
                }
                GameType.COMPUTER -> {
                    playerOne.icon = R.drawable.ic_personal_video_black_24dp
                    playerTwo.icon = R.drawable.ic_personal_video_black_24dp
                }
            }
        })
    }

    private fun getData() {
        viewModel.gameMode.value = arguments?.getSerializable("type") as? GameType
    }
}