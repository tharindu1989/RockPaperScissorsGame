package com.th.game.feature.game.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.th.game.R
import com.th.game.feature.base.BaseFragment
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

    }

    private fun setObservers() {

        viewModel.getCount().observe(this, Observer {
            countTxt.text = "COUNT $it"
        })
    }

    private fun getData() {

    }
}