package com.course.clean.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by antonmaksimov on 2/16/19.
 * anton.maksimov@umbrella-web.com
 */

abstract class BaseFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}