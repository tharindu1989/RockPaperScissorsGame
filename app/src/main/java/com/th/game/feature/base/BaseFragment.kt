package com.th.game.feature.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.th.game.feature.game.GameActivity

/**
 * Created By Tharindu on 8/18/2019
 *
 */
open class BaseFragment : Fragment() {

    var mActivity: GameActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as? GameActivity
    }

    /**
     * Add Fragment
     * @param fragment : Fragment to Add
     * @param tag : TAG
     * @param bundle : Extra Data
     */
    fun addFragment(fragment: Fragment, tag: String, bundle: Bundle? = null) {
        mActivity?.addFragment(fragment, tag, bundle)
    }
}