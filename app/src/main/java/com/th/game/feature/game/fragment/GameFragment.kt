package com.th.game.feature.game.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.th.game.R
import com.th.game.feature.base.BaseFragment

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class GameFragment : BaseFragment() {

    companion object {
        const val TAG = "GameFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
}