package me.monster.blogtest.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.monster.blogtest.R

/**
 * @description
 * @author: Created jiangjiwei in 2019-07-11 13:26
 */
class SwipeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_swipe, container, false)
    }

}