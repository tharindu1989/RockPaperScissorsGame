package com.th.game.feature.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.th.game.R
import com.th.game.feature.base.BaseActivity
import com.th.game.feature.game.fragment.GameFragment

/**
 * Created By Tharindu on 8/18/2019
 *
 */
class GameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val bundle = intent.getBundleExtra("bundle")
        addFragment(GameFragment(), GameFragment.TAG, bundle, false)
    }


    /**
     * add Fragment to Container
     */
    fun addFragment(
        fragment: Fragment,
        tag: String,
        bundle: Bundle? = null,
        isAddToBackStack: Boolean = true
    ) {

        bundle?.let {
            fragment.arguments = bundle
        }
        val fragmentManager = this.supportFragmentManager
        val ft = fragmentManager?.beginTransaction()
        if (isAddToBackStack) {
            ft?.add(R.id.container, fragment, tag)
            ft?.addToBackStack(tag)
        } else {
            ft?.replace(R.id.container, fragment, tag)
        }
        ft?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft?.commit()
    }

}